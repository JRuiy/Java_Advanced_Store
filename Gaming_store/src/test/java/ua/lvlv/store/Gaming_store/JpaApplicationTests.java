package ua.lvlv.store.Gaming_store;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lvlv.store.dao.BasketRepository;
import ua.lvlv.store.dao.GameRepository;
import ua.lvlv.store.dao.UserRepository;
import ua.lvlv.store.domain.Basket;
import ua.lvlv.store.domain.Game;
import ua.lvlv.store.domain.User;
import ua.lvlv.store.domain.UserRole;
import ua.lvlv.store.service.BasketService;
import ua.lvlv.store.service.GamesService;
import ua.lvlv.store.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class JpaApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private GamesService gameService;
	
	@Autowired
	private BasketService basketService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private BasketRepository basketRepository;
	
	@Test
	void testSaveUser() {
		
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));
		
		User user = new User();
		user.setEmail("11@gmail.com");
		user.setFirstName("11");
		user.setLastName("11");
		user.setPassword("11");
		user.setPasswordConfim("11");
		user.setPhone("11");
		user.setUserRole(UserRole.ROLE_USER);
		
		userService.save(user);
		
		users = userRepository.findAll();
		assertThat(users, hasSize(1));
		
		User userFromDb = users.get(0);
		assertTrue(userFromDb.getEmail().equals(user.getEmail()));
		assertTrue(userFromDb.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDb.getLastName().equals(user.getLastName()));
		assertTrue(userFromDb.getUserRole().equals(user.getUserRole()));
		
	}
	
	@Test
	void testFindByEmail() {
		
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));
		
		User user = new User();
		user.setEmail("email@gmail.com");
		user.setFirstName("22");
		user.setLastName("22");
		user.setPassword("22");
		user.setPasswordConfim("22");
		user.setPhone("22");
		user.setUserRole(UserRole.ROLE_USER);
		
		userRepository.save(user);
		
		users = userRepository.findAll();
		assertThat(users, hasSize(1));
		
		User findByEmail = userService.findByEmail(user.getEmail());

		assertTrue(findByEmail.getEmail().equals(user.getEmail()));
		assertTrue(findByEmail.getFirstName().equals(user.getFirstName()));
		assertTrue(findByEmail.getLastName().equals(user.getLastName()));
		assertTrue(findByEmail.getUserRole().equals(user.getUserRole()));
		
	}

	@Test
	void testSaveGame() {
		List<Game> games = gameRepository.findAll();
		assertThat(games, hasSize(0));
		
		Game game = new Game();
		game.setDescription("1");
		game.setEncodedImage("1");
		game.setGenre("1");
		game.setName("1");
		game.setPlatform("1");
		game.setPrice(1.0);
		game.setPublisher("1");
		
		gameService.save(game);
		
		games = gameRepository.findAll();
		assertThat(games, hasSize(1));
		
		Game gameFromDb = games.get(0);
		assertTrue(gameFromDb.getDescription().equals(game.getDescription()));
		assertTrue(gameFromDb.getEncodedImage().equals(game.getEncodedImage()));
		assertTrue(gameFromDb.getGenre().equals(game.getGenre()));
		assertTrue(gameFromDb.getName().equals(game.getName()));
		assertTrue(gameFromDb.getPlatform().equals(game.getPlatform()));
		assertTrue(gameFromDb.getPrice().equals(game.getPrice()));
		assertTrue(gameFromDb.getPublisher().equals(game.getPublisher()));
	}

	@Test
	void testFindById() {
		
		List<Game> games = gameRepository.findAll();
		assertThat(games, hasSize(0));
		
		Game game = new Game();
		game.setDescription("1");
		game.setEncodedImage("1");
		game.setGenre("1");
		game.setName("1");
		game.setPlatform("1");
		game.setPrice(1.0);
		game.setPublisher("1");
		
		gameRepository.save(game);
		
		games = gameRepository.findAll();
		assertThat(games, hasSize(1));
		
		Game gameFromDb = gameService.findByID(1);
		
		assertTrue(gameFromDb.getDescription().equals(game.getDescription()));
		assertTrue(gameFromDb.getEncodedImage().equals(game.getEncodedImage()));
		assertTrue(gameFromDb.getGenre().equals(game.getGenre()));
		assertTrue(gameFromDb.getName().equals(game.getName()));
		assertTrue(gameFromDb.getPlatform().equals(game.getPlatform()));
		assertTrue(gameFromDb.getPrice().equals(game.getPrice()));
		assertTrue(gameFromDb.getPublisher().equals(game.getPublisher()));
		
	}
	
	@Test
	void testGetAllGames() {
		List<Game> games = gameRepository.findAll();
		assertThat(games, hasSize(0));
		
		Game game = new Game();
		game.setDescription("1");
		game.setEncodedImage("1");
		game.setGenre("1");
		game.setName("1");
		game.setPlatform("1");
		game.setPrice(1.0);
		game.setPublisher("1");
		
		Game game2 = new Game();
		game2.setDescription("2");
		game2.setEncodedImage("2");
		game2.setGenre("2");
		game2.setName("2");
		game2.setPlatform("2");
		game2.setPrice(2.0);
		game2.setPublisher("2");
		
		gameRepository.saveAll(Arrays.asList(game, game2));
		
		games = gameRepository.findAll();
		assertThat(games, hasSize(2));
		
		List<Game> gameFromDb = gameService.getAllGames();
		
		assertTrue(gameFromDb.get(0).getDescription().equals(game.getDescription()));
		assertTrue(gameFromDb.get(0).getEncodedImage().equals(game.getEncodedImage()));
		assertTrue(gameFromDb.get(0).getGenre().equals(game.getGenre()));
		assertTrue(gameFromDb.get(0).getName().equals(game.getName()));
		assertTrue(gameFromDb.get(0).getPlatform().equals(game.getPlatform()));
		assertTrue(gameFromDb.get(0).getPrice().equals(game.getPrice()));
		assertTrue(gameFromDb.get(0).getPublisher().equals(game.getPublisher()));
		
		assertTrue(gameFromDb.get(1).getDescription().equals(game2.getDescription()));
		assertTrue(gameFromDb.get(1).getEncodedImage().equals(game2.getEncodedImage()));
		assertTrue(gameFromDb.get(1).getGenre().equals(game2.getGenre()));
		assertTrue(gameFromDb.get(1).getName().equals(game2.getName()));
		assertTrue(gameFromDb.get(1).getPlatform().equals(game2.getPlatform()));
		assertTrue(gameFromDb.get(1).getPrice().equals(game2.getPrice()));
		assertTrue(gameFromDb.get(1).getPublisher().equals(game2.getPublisher()));
	}
	
	@Test
	void testAddToBasekt() {
		User user = new User();
		user.setEmail("11@gmail.com");
		user.setFirstName("11");
		user.setLastName("11");
		user.setPassword("11");
		user.setPasswordConfim("11");
		user.setPhone("11");
		user.setUserRole(UserRole.ROLE_USER);
		
		userService.save(user);
		
		User userFromDb = userRepository.findAll().stream().findFirst().get();
		
		List<Game> games = gameRepository.findAll();
		assertThat(games, hasSize(0));
		
		Game game = new Game();
		game.setDescription("1");
		game.setEncodedImage("1");
		game.setGenre("1");
		game.setName("1");
		game.setPlatform("1");
		game.setPrice(1.0);
		game.setPublisher("1");
		
		gameService.save(game);
		
		Game gameFromDb = gameRepository.findAll().stream().findFirst().get();
		
		Date now = new Date();
		Basket basket = new Basket();
		basket.setGame(gameFromDb);
		basket.setUser(userFromDb);
		basket.setPurchaseDate(now);
		
		List<Basket> baskets = basketRepository.findAll();
		assertThat(baskets, hasSize(0));
		
		basketService.add(basket);
		
		baskets = basketRepository.findAll();
		assertThat(baskets, hasSize(1));
		
		Basket basketFromDb = baskets.get(0);
		
		assertTrue(basketFromDb.getGame().equals(gameFromDb));
		assertTrue(basketFromDb.getUser().equals(userFromDb));
//		assertTrue(basketFromDb.getPurchaseDate().equals(now));	
	}
	
	@Test
	void testDeleteFromBasket() {
		User user = new User();
		user.setEmail("11@gmail.com");
		user.setFirstName("11");
		user.setLastName("11");
		user.setPassword("11");
		user.setPasswordConfim("11");
		user.setPhone("11");
		user.setUserRole(UserRole.ROLE_USER);
		
		userService.save(user);
		
		User userFromDb = userRepository.findAll().stream().findFirst().get();
		
		List<Game> games = gameRepository.findAll();
		assertThat(games, hasSize(0));
		
		Game game = new Game();
		game.setDescription("1");
		game.setEncodedImage("1");
		game.setGenre("1");
		game.setName("1");
		game.setPlatform("1");
		game.setPrice(1.0);
		game.setPublisher("1");
		
		Game game2 = new Game();
		game2.setDescription("2");
		game2.setEncodedImage("2");
		game2.setGenre("2");
		game2.setName("2");
		game2.setPlatform("2");
		game2.setPrice(2.0);
		game2.setPublisher("2");
		
		gameRepository.saveAll(Arrays.asList(game, game2));
		
		List<Game> gamesFromDb = gameRepository.findAll();
		
		Date now = new Date();
		Basket basket = new Basket();
		basket.setGame(gamesFromDb.get(0));
		basket.setUser(userFromDb);
		basket.setPurchaseDate(now);

		Basket basket2 = new Basket();
		basket.setGame(gamesFromDb.get(1));
		basket.setUser(userFromDb);
		basket.setPurchaseDate(now);
		
		List<Basket> baskets = basketRepository.findAll();
		assertThat(baskets, hasSize(0));
		
		basketRepository.saveAll(Arrays.asList(basket, basket2));
		
		baskets = basketRepository.findAll();
		assertThat(baskets, hasSize(2));
		
		basketService.delete(baskets.get(0));
		
		baskets = basketRepository.findAll();
		assertThat(baskets, hasSize(1));
	}
	
	@Test
	void testGetAllFromBasket() {
		User user = new User();
		user.setEmail("11@gmail.com");
		user.setFirstName("11");
		user.setLastName("11");
		user.setPassword("11");
		user.setPasswordConfim("11");
		user.setPhone("11");
		user.setUserRole(UserRole.ROLE_USER);
		
		userService.save(user);
		
		User userFromDb = userRepository.findAll().stream().findFirst().get();
		
		List<Game> games = gameRepository.findAll();
		assertThat(games, hasSize(0));
		
		Game game = new Game();
		game.setDescription("1");
		game.setEncodedImage("1");
		game.setGenre("1");
		game.setName("1");
		game.setPlatform("1");
		game.setPrice(1.0);
		game.setPublisher("1");
		
		Game game2 = new Game();
		game2.setDescription("2");
		game2.setEncodedImage("2");
		game2.setGenre("2");
		game2.setName("2");
		game2.setPlatform("2");
		game2.setPrice(2.0);
		game2.setPublisher("2");
		
		gameRepository.saveAll(Arrays.asList(game, game2));
		
		List<Game> gamesFromDb = gameRepository.findAll();
		
		Date now = new Date();
		Basket basket = new Basket();
		basket.setGame(gamesFromDb.get(0));
		basket.setUser(userFromDb);
		basket.setPurchaseDate(now);

		Basket basket2 = new Basket();
		basket.setGame(gamesFromDb.get(1));
		basket.setUser(userFromDb);
		basket.setPurchaseDate(now);
		
		List<Basket> baskets = basketRepository.findAll();
		assertThat(baskets, hasSize(0));
		
		basketRepository.saveAll(Arrays.asList(basket, basket2));
		
		List<Basket> basketFromDb = basketService.getAllfromBasket();
		assertThat(basketFromDb, hasSize(2));
		
	}
	
}

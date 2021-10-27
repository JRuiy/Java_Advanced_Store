package ua.lvlv.store.Gaming_store;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lvlv.store.dao.UserRepository;
import ua.lvlv.store.domain.User;
import ua.lvlv.store.domain.UserRole;
import ua.lvlv.store.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class GamingStoreApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void contextLoads() {
		
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(5));
		
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
		assertThat(users, hasSize(6));
		
		User userFromDb = users.get(0);
		assertTrue(userFromDb.getEmail().equals(user.getEmail()));
		assertTrue(userFromDb.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDb.getLastName().equals(user.getLastName()));
		assertTrue(userFromDb.getUserRole().equals(user.getUserRole()));
		
	}

}

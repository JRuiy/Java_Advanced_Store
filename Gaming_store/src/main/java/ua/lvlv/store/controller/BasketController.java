package ua.lvlv.store.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.lvlv.store.domain.Basket;
import ua.lvlv.store.domain.Game;
import ua.lvlv.store.domain.User;
import ua.lvlv.store.service.BasketService;
import ua.lvlv.store.service.GamesService;
import ua.lvlv.store.service.UserService;

@Controller
public class BasketController {
	
	@Autowired
	private BasketService basketService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GamesService gamesService;

	@RequestMapping(value = "/baskets", method = RequestMethod.GET)
	public ModelAndView getAllItems() {
		return getBasketItems();
	}
	
	@RequestMapping(value = "/basket", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam String gameId) {
		Game game = gamesService.findByID(Integer.parseInt(gameId));
		
		Basket basket = new Basket();
		basket.setGame(game);
		basket.setPurchaseDate(new Date());
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		
		String userEmail = authentication.getName();
		User user = userService.findByEmail(userEmail);
		basket.setUser(user);
		basketService.add(basket);
		return getBasketItems();
	}
	
	@RequestMapping(value = "/basket", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam String id) {
		basketService.delete(new Basket(Integer.parseInt(id.replaceAll("\\s",""))));
		return getBasketItems();	
	}
	
	private ModelAndView getBasketItems() {
		ModelAndView map = new ModelAndView("basket");
		map.addObject("basketItems", basketService.getAllfromBasket());
		return map;
	}
}

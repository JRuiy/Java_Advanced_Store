package ua.lvlv.store.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.lvlv.store.domain.Game;
import ua.lvlv.store.service.GamesService;

@Controller
public class GamesController {

	@Autowired
	GamesService gamesService;
	
	@RequestMapping(value = "/addGame", method = RequestMethod.POST)
	public ModelAndView createGame (@Valid @ModelAttribute("game") Game game, BindingResult result) {
		gamesService.save(game);
		return new ModelAndView("redirect:/home");
	}
}

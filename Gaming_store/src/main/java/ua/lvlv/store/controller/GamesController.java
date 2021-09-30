package ua.lvlv.store.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.lvlv.store.service.GamesDTOHelper;
import ua.lvlv.store.service.GamesService;

@Controller
public class GamesController {

	@Autowired
	GamesService gamesService;
	
	@RequestMapping(value = "/addGame", method = RequestMethod.POST)
	public ModelAndView createGame (
			@RequestParam MultipartFile image, 
			@RequestParam String name, 
			@RequestParam String description, 
			@RequestParam Double price,
			@RequestParam String platform, 
			@RequestParam String publisher, 
			@RequestParam String genre, 
			@RequestParam String release) throws IOException {
		gamesService.save(GamesDTOHelper.createEntity(image, name, description, platform, publisher, genre, null, price));
		return new ModelAndView("redirect:/home");
	}
}

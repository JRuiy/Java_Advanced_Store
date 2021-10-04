package ua.lvlv.store.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lvlv.store.dao.GameRepository;
import ua.lvlv.store.domain.Game;

@Service
public class GamesService {
	
	private Logger logger = LoggerFactory.getLogger(GamesService.class);

	@Autowired
	GameRepository gameRepository;

	public Game save(Game game) {
		logger.info("Create periodical item {} : " + game);
		return gameRepository.save(game);
	}
	
	public List<Game> getAllGames(){
		logger.info("Get all games items");
		return gameRepository.findAll();
	}
	
	public Game findByID(Integer id) {
		logger.info("Get game item by id: " + id);
		return gameRepository.getById(id);
	}
}

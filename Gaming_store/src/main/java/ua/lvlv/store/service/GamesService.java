package ua.lvlv.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lvlv.store.dao.GameRepository;
import ua.lvlv.store.domain.Game;

@Service
public class GamesService {

	@Autowired
	GameRepository gameRepository;

	public Game save(Game game) {
		return gameRepository.save(game);
	}
	
	public List<Game> getAllGames(){
		return gameRepository.findAll();
	}
	
	public Game findByID(Integer id) {
		return gameRepository.getById(id);
	}
}

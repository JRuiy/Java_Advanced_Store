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
	
//	public List<String> getAllPlatform(){
//		List<String> listOfPlatform = new ArrayList<String>();
//		for (Platform platform : Platform.values()) {
//			listOfPlatform.add(platform.toString());
//		}
//		return listOfPlatform;
//	}
}

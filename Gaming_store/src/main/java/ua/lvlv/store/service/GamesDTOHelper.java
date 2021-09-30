package ua.lvlv.store.service;

import java.io.IOException;
import java.sql.Date;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import ua.lvlv.store.domain.Game;

public class GamesDTOHelper {

	public static Game createEntity(MultipartFile file, String name, String description,String platform, String publisher, String genre, Date release ,Double price) throws IOException {
		Game game = new Game();
		game.setName(name);
		game.setDescription(description);
		game.setPlatform(platform);
		game.setPublisher(publisher);
		game.setRelease(release);
		game.setGenre(genre);
		game.setPrice(price);
		game.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		return game;
	}
	
}

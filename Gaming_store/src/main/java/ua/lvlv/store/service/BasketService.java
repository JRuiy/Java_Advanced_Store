package ua.lvlv.store.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lvlv.store.dao.BasketRepository;
import ua.lvlv.store.domain.Basket;

@Service
public class BasketService {
	
	private Logger logger  = LoggerFactory.getLogger(Basket.class);

	@Autowired
	BasketRepository basketRepository;
	
	
	public List<Basket> getAllfromBasket(){
		logger.info("Get all baskets items");
		return basketRepository.findAll();
	}
	
	public void delete(Basket basket) {
		logger.info("Delete basket item {} : " + basket);
		basketRepository.delete(basket);
	}
	
	public Basket add(Basket basket) {
		logger.info("Create new basket item {}: " + basket);
		return basketRepository.save(basket);
	}
}

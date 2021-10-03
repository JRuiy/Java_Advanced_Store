package ua.lvlv.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lvlv.store.dao.BasketRepository;
import ua.lvlv.store.domain.Basket;

@Service
public class BasketService {

	@Autowired
	BasketRepository basketRepository;
	
	
	public List<Basket> getAllfromBasket(){
		return basketRepository.findAll();
	}
	
	public void delete(Basket basket) {
		basketRepository.delete(basket);
	}
	
	public Basket add(Basket basket) {
		return basketRepository.save(basket);
	}
}

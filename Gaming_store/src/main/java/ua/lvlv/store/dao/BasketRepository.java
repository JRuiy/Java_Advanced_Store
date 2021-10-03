package ua.lvlv.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lvlv.store.domain.Basket;

public interface BasketRepository extends JpaRepository<Basket, Integer>{

}

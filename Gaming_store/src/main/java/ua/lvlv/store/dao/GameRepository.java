package ua.lvlv.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lvlv.store.domain.Game;

public interface GameRepository extends JpaRepository<Game, Integer>{

}

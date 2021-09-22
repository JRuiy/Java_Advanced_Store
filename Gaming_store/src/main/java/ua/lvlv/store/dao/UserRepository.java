package ua.lvlv.store.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lvlv.store.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
	
}

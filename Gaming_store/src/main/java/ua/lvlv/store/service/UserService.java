package ua.lvlv.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.lvlv.store.dao.UserRepository;
import ua.lvlv.store.domain.User;
import ua.lvlv.store.domain.UserRole;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPasswordConfim(passwordEncoder.encode(user.getPasswordConfim()));
        user.setUserRole(UserRole.ROLE_USER);
        userRepository.save(user);
    }
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).get();
	}
}

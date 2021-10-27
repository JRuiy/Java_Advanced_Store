package ua.lvlv.store.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ua.lvlv.store.dao.UserRepository;
import ua.lvlv.store.domain.User;
import ua.lvlv.store.domain.UserRole;

@Service
@Component
public class UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void save(User user) {
		logger.info("Register new user {} : " + user);
		
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPasswordConfim(passwordEncoder.encode(user.getPasswordConfim()));
        user.setUserRole(UserRole.ROLE_USER);
        userRepository.save(user);
    }
	
	public User findByEmail(String email) {
		logger.info("Get user {} by email: " + email);
		
		return userRepository.findByEmail(email).get();
	}
}

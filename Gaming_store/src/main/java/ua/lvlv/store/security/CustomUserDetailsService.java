package ua.lvlv.store.security;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.lvlv.store.dao.UserRepository;
import ua.lvlv.store.domain.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<User> userOptional = userRepository.findByEmail(email);
		
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			return new CustomUserDetails(user, Collections.singletonList(user.getUserRole().toString()));
		}
		
		throw new UsernameNotFoundException("No user present with useremail:" + email);
	}

}

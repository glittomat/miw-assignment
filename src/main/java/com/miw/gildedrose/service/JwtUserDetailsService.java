package com.miw.gildedrose.service;

import java.util.ArrayList;

import org.hibernate.mapping.Array;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.miw.gildedrose.controller.JwtAuthenticationController;
import com.miw.gildedrose.domain.UserDao;
import com.miw.gildedrose.persistence.UserRepository;


/**
 * The UserDetailsService implementation for the app.
 *  
 * @author glitto.mathew
 *
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * Function to load the userName(it can be from DB & other sources as well)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.debug("userName : " , username);		
		UserDao user = userRepository.findByUsername(username);
		if (user.getUsername().equals(username)) {
			return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	
	
	
//	
//		@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
//		
//		logger.debug("userNMae : " , username);
//		if ("foo".equals(username)) {
//			return new User("foo", "foo", new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		
//		
//	}

}

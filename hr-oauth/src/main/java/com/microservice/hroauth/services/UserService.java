package com.microservice.hroauth.services;

import static java.util.Objects.isNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microservice.hroauth.entities.User;
import com.microservice.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userFeign;

	public User findByEmail(String email) {
		User user = userFeign.findByEmail(email).getBody();

		if (isNull(user)) {
			logger.error("email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}

		logger.info("email found: " + email);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeign.findByEmail(username).getBody();

		if (isNull(user)) {
			logger.error("email not found: " + username);
			throw new IllegalArgumentException("Email not found");
		}

		logger.info("email found: " + username);
		return user;
	}
}

package com.microservice.hroauth.services;

import static java.util.Objects.isNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hroauth.entities.User;
import com.microservice.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeign;
	
	public User findByEmail(String email) {
		User user = userFeign.findByEmail(email).getBody();
		
		if(isNull(user)) {
			logger.error("email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		
		logger.info("email found: " + email);
		return user;
	}
}

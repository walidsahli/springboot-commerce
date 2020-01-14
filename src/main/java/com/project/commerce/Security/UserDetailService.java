package com.project.commerce.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.project.commerce.Models.User;
import com.project.commerce.Repositories.UserRepository;

@Component
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	UserRepository repo;

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		return repo.findByUsername(username);
	}

}

package com.project.commerce.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.project.commerce.Models.Entities.User;
import com.project.commerce.Models.Utils.UserDetailsImp;
import com.project.commerce.Repositories.UserRepository;

@Component
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	UserRepository repo;

	@Override
	public UserDetailsImp loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  repo.findByUsername(username);
		return UserDetailsImp.build(user);
	}

}

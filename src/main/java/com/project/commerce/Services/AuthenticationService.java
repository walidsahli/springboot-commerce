package com.project.commerce.Services;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.commerce.Models.AuthenticationResponse;
import com.project.commerce.Models.BadCredentials;
import com.project.commerce.Models.RegistrationResponse;
import com.project.commerce.Models.User;
import com.project.commerce.Repositories.UserRepository;
import com.project.commerce.Security.JwtUtil;
import com.project.commerce.Security.UserDetailService;

@Service
public class AuthenticationService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailService userDetailService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public ResponseEntity<?> Login (String username , String password) throws Exception{
		try {
		authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username, password)
				);
		}catch(BadCredentialsException e) {
			return ResponseEntity.status(403).body(new BadCredentials(e.getMessage()));
		}
		User user = userDetailService.loadUserByUsername(username);
		String jwt = jwtUtil.generateToken(user);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	public ResponseEntity<?> Register (User user) throws Exception{
		try {
			String password = passwordEncoder.encode(user.getPassword());
			user.setPassword(password);
			userRepository.save(user);
			return ResponseEntity.ok(new RegistrationResponse("Successfully registred"));
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(409).body(e.getMessage());
		} catch(Exception e ) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

}

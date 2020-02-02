package com.project.commerce.Services;

import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.commerce.Models.Entities.Role;
import com.project.commerce.Models.Entities.User;
import com.project.commerce.Models.Utils.AuthenticationResponse;
import com.project.commerce.Models.Utils.BadCredentials;
import com.project.commerce.Models.Utils.EnumRole;
import com.project.commerce.Models.Utils.RegisterRequest;
import com.project.commerce.Models.Utils.RegistrationResponse;
import com.project.commerce.Models.Utils.UserDetailsImp;
import com.project.commerce.Repositories.RoleRepository;
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
	RoleRepository roleRepository;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public ResponseEntity<?> Login (String username , String password) throws Exception{
		try {
		Authentication authentication =  authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username, password)
				);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		}catch(InternalAuthenticationServiceException e) {
			return ResponseEntity.status(404).body(new BadCredentials("User not Found"));
		}catch(BadCredentialsException e) {
			System.out.println(e);
			return ResponseEntity.status(403).body(new BadCredentials(e.getMessage()));
		}catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		UserDetailsImp user = userDetailService.loadUserByUsername(username);
		String jwt = jwtUtil.generateToken(user);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	public ResponseEntity<?> Register (RegisterRequest userToRegister) throws Exception{
		try {
			Role role1 = new Role(EnumRole.ROLE_ADMIN);
			Role role2 = new Role(EnumRole.ROLE_USER);
			Set <Role> roles = new HashSet<>();
			roles.add(role1); roles.add(role2);
			roleRepository.saveAll((Iterable<Role>) roles);
			String password = passwordEncoder.encode(userToRegister.getPassword());
			User user =  new User();
			user.setFirstName(userToRegister.getFirstName());
			user.setLastName(userToRegister.getLastName());
			user.setEmail(userToRegister.getEmail());
			user.setLatitude(userToRegister.getLatitude());
			user.setLongitude(userToRegister.getLongitude());
			user.setUsername(userToRegister.getUsername());
			user.setPhoneNumber(userToRegister.getPhoneNumber());
			user.setPassword(password);
			user.setLocation(userToRegister.getLocation());
			String gotenRole = userToRegister.getRole();
			System.out.println(userToRegister.getRole());
			Set<Role> rolesList = new HashSet<>();
			switch (gotenRole) {
				case "ADMIN":
					Role adminRole = roleRepository.findByName(EnumRole.ROLE_ADMIN);
					System.out.println(adminRole);
					rolesList.add(adminRole);
					break;
				case "USER":
					Role userRole = roleRepository.findByName(EnumRole.ROLE_USER);
					System.out.println(userRole);
					rolesList.add(userRole);
					break;
				}
			System.out.println(rolesList.size());
			user.setRoles(rolesList);
			System.out.println(user.toString());
			userRepository.save(user);
			return ResponseEntity.ok(new RegistrationResponse("Successfully registred"));
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(409).body(e.getMessage());
		} catch(Exception e ) {
			System.out.println(e);
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

}

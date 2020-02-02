package com.project.commerce.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.commerce.Models.Utils.AuthenticationRequest;
import com.project.commerce.Models.Utils.RegisterRequest;
import com.project.commerce.Services.AuthenticationService;

@RestController
@RequestMapping(path = "/auth")
public class AuthenticationController {
	
	@Autowired
	AuthenticationService service;
	
	@PostMapping(path = "/login")
	public ResponseEntity<?> login (@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
			return service.Login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		} catch (Exception e) {
			throw new Exception("Error",e);
		}
	}
	
	@PostMapping(path = "/register")
	public ResponseEntity<?> register(@RequestBody @ Valid RegisterRequest user) throws Exception{
		return service.Register(user);
	}
}

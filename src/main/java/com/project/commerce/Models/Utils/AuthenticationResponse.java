package com.project.commerce.Models.Utils;

public class AuthenticationResponse {
	
	private String token;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthenticationResponse(String token) {
		this.token = token;
	}
	
}

package com.project.commerce.Models;

public class RegistrationResponse {
	public RegistrationResponse(String message) {
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

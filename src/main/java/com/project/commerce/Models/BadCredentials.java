package com.project.commerce.Models;

import org.springframework.security.authentication.BadCredentialsException;

public class BadCredentials extends BadCredentialsException{

	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return this.msg;
	}
	
	public BadCredentials(String msg) {
		super(msg);
		this.msg = msg;
	}

}

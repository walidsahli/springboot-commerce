package com.project.commerce.Models.Utils;

import org.springframework.dao.DuplicateKeyException;

public class RegisterResponse extends DuplicateKeyException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public RegisterResponse(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}

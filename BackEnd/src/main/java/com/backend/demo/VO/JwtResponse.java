package com.backend.demo.VO;

import java.io.Serializable;

public class JwtResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String jwttoken;
	
	public JwtResponse(String token) {
		this.jwttoken = token;
	}
	public String getToken() {
		return this.jwttoken;
	}

	
}

package com.gpcoder.service;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface AuthService {

	@RequestLine("POST /auth")
	@Headers({ 
		"Accept: application/json; charset=utf-8", 
		"Content-Type: application/x-www-form-urlencoded" })
	String getToken(@Param("username") String username, @Param("password") String password);
}

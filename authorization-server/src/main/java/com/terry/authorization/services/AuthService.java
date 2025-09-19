package com.terry.oauth.services;

public interface AuthService {
	
	String authenticate(String username, String password) throws Exception;

}

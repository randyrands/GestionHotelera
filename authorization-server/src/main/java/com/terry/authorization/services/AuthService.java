package com.terry.authorization.services;

public interface AuthService {
    String authenticate(String username, String password) throws Exception;
}

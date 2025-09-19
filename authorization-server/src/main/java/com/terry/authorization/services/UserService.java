package com.terry.authorization.services;

import java.util.Set;

import com.terry.authorization.dto.UserRequest;
import com.terry.authorization.dto.UserResponse;

public interface UserService {
		
		Set<UserResponse> listarUsuarios();
		UserResponse crearUsuario(UserRequest request);
		UserResponse eliminarUsuario(String username);
}

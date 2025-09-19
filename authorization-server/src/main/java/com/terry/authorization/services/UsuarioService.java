package com.terry.authorization.services;

import java.util.Set;

import com.terry.authorization.dto.UsuarioRequest;
import com.terry.authorization.dto.UsuarioResponse;

public interface UsuarioService {
	
	Set<UsuarioResponse> listarUsuarios();

	UsuarioResponse crearUsuario(UsuarioRequest request);
	
	UsuarioResponse eliminarUsuario(String username);
}

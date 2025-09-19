package com.terry.oauth.services;

import java.util.Set;

import com.terry.oauth.dto.UsuarioRequest;
import com.terry.oauth.dto.UsuarioResponse;

public interface UsuarioService {
	
	Set<UsuarioResponse> listarUsuarios();

	UsuarioResponse crearUsuario(UsuarioRequest request);
	
	UsuarioResponse eliminarUsuario(String username);
}

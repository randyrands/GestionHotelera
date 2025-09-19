package com.terry.authorization.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terry.authorization.dto.UsuarioRequest;
import com.terry.authorization.dto.UsuarioResponse;
import com.terry.authorization.entities.Rol;
import com.terry.authorization.entities.Usuario;
import com.terry.authorization.repositories.RoleRepository;
import com.terry.authorization.repositories.UserRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private final UserRepository usuarioRepository;
	
	private final RoleRepository rolRepository;
	
	private final PasswordEncoder passwordEncoder;

	public UsuarioServiceImpl(UserRepository usuarioRepository, RoleRepository rolRepository,
			PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.rolRepository = rolRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	@Transactional(readOnly = true)
	public Set<UsuarioResponse> listarUsuarios() {
		return usuarioRepository.findAll().stream()
                .map(u -> new UsuarioResponse(
                        u.getUsername(),
                        u.getRoles().stream()
                        	.map(Rol::getNombre)
                        	.collect(Collectors.toSet())
                )).collect(Collectors.toSet());
	}

	@Override
	@Transactional
	public UsuarioResponse crearUsuario(UsuarioRequest request) {
		if (usuarioRepository.findByUsername(request.username()).isPresent()) {
            throw new RuntimeException("El usuario ya existe");
        }

        Set<Rol> roles = request.roles().stream()
                .map(nombre -> rolRepository.findByNombre(nombre)
                        .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + nombre)))
                .collect(Collectors.toSet());

        Usuario usuario = new Usuario();
        usuario.setUsername(request.username());
        usuario.setPassword(passwordEncoder.encode(request.password()));
        usuario.setRoles(roles);

        usuarioRepository.save(usuario);

        return new UsuarioResponse(usuario.getUsername(),
                usuario.getRoles().stream().map(Rol::getNombre).collect(Collectors.toSet()));
	}

	@Override
	@Transactional
	public UsuarioResponse eliminarUsuario(String username) {
		Usuario usuario = usuarioRepository.findByUsername(username).orElseThrow();
		usuarioRepository.deleteByUsername(username);
		return new UsuarioResponse(usuario.getUsername(),
                usuario.getRoles().stream().map(Rol::getNombre).collect(Collectors.toSet()));
	}

}

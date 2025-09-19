package com.terry.authorization.services;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terry.authorization.dto.UserRequest;
import com.terry.authorization.dto.UserResponse;
import com.terry.authorization.models.Role;
import com.terry.authorization.models.User;
import com.terry.authorization.repositories.RoleRepository;
import com.terry.authorization.repositories.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
    private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}
	@Override
	@Transactional(readOnly = true)
	public Set<UserResponse> listarUsuarios() {
		return userRepository.findAll().stream()
				.map(user -> new UserResponse(user.getUsername(),user.getRoles().stream()
						.map(Role::getNombre).collect(Collectors.toSet()))
						).collect(Collectors.toSet());
	}
	@Override
	public UserResponse crearUsuario(UserRequest request) {
		if(userRepository.findByUsername(request.username()).isPresent()) {
			throw new IllegalArgumentException("Ya está registrado el usuario: "+ request.username());
		}
		
		Set<Role>  roles = request.roles().stream().map(rol -> roleRepository.findByNombre(rol)
				.orElseThrow(()-> new NoSuchElementException("Rol no encontrados: "+rol)))
				.collect(Collectors.toSet());
		
		
		User user = new User();
		user.setUsername(request.username());
		user.setPassword(passwordEncoder.encode(request.password()));
		user.setRoles(roles);
		user = userRepository.save(user);
		return new UserResponse(user.getUsername(),user.getRoles().stream()
				.map(Role::getNombre).collect(Collectors.toSet())
				);
				
	}
	@Override
	public UserResponse eliminarUsuario(String username) {
		User user = userRepository.findByUsername(username).orElseThrow(
				()-> new NoSuchElementException("No se encontrado con el usuario: "+ username));
		userRepository.deleteById(user.getId());
		return new UserResponse(user.getUsername(),user.getRoles().stream()
				.map(Role::getNombre).collect(Collectors.toSet())
				);
	}
	
	

}

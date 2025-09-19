package com.terry.authorization.services;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.terry.authorization.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	private final UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    com.terry.authorization.models.User user = userRepository.findByUsername(username)
	        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado en BD"));

	    return new org.springframework.security.core.userdetails.User(
	        user.getUsername(),
	        user.getPassword(),
	        user.getRoles()
	            .stream()
	            .map(r -> new SimpleGrantedAuthority(r.getNombre()))
	            .collect(Collectors.toSet())
	    );
	}

	
	

}

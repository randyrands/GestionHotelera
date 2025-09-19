package com.terry.authorization.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
		@NotBlank(message = "El username es requerido")
		@Size(min = 5, max =20, message ="El username debe de tener entre 5 y 20 caracteres" )
		String username,
		@NotBlank(message = "El password es requerido")
		@Size(min = 8, message ="El password debe de tener al menos 8 caracteres" )
		String password,
		@NotBlank(message = "Los roles son requeridos")
		@Size(min = 1, message ="El usuario debe de tener al menos 1 rol" )
		Set<String> roles
		) {

}

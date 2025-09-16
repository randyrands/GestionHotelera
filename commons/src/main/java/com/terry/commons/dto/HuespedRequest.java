package com.terry.commons.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record HuespedRequest(
		@NotBlank(message = "El nombre es requerido")
		@Size(min = 1, max =30, message ="El nombre debe de tener entre 1 y 30 caracteres" )
		String nombre,
		@NotBlank(message = "El apellido es requerido")
		@Size(min = 1, max =30, message ="El nombre debe de tener entre 1 y 30 caracteres" )
		String apellido,
		@NotBlank(message = "El email es requerido")
		@Size(min = 1, max =30, message ="El nombre debe de tener entre 1 y 30 caracteres" )
		String email,
		
		@NotBlank(message = "El telefono es requerido")
		@Size(min = 10, message ="El numero de telefono debe de tener 10 caracteres" )
		String telefono,
		
		@NotBlank(message = "El documento es requerido")
		String documento,
		
		@NotBlank(message = "La nacionalidad es requerido")
		String nacionalidad
		) 
{}

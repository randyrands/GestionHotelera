package com.terry.commons.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record HabitacionRequest(
		@NotNull(message = "El numero es requerido")
		Long numero,
		@NotBlank(message = "El tipo es requerido")
		String tipo,
		
		@Size(min = 1, max =30, message ="La descripcion debe de tener entre 5 y 30 caracteres" )
		@NotBlank(message = "La descripcion es requerido")
		String descripcion,
		
		@NotNull(message = "El precio es requerido")
		BigDecimal  precio,
		
		@NotNull(message = "La capacidad es requerida")
		Long capacidad,
		
		@NotBlank(message = "El estado es requerido")
		String estado
		) {

}

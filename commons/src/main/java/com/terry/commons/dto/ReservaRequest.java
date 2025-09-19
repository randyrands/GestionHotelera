package com.terry.commons.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



public record ReservaRequest(
		
		
		
		@NotNull(message = "La fecha de entrada es requerida")
		Date fecha_entrada,
		@NotNull(message = "La fecha de salida es requerida")
		Date fecha_salida,
		
		@NotNull(message = "Las noches son requeridas")
		Integer noches,
		
		@NotNull(message = "El total es requerido")
		BigDecimal total,
		
		@NotBlank(message = "El estado es requerido")
		String estado,
		@NotNull(message = "El Huesped es requerido")
		Long idHuesped,
		@NotNull(message = "La habitacion es requerida")
		Set<Long> idHabitaciones
		
		
		) {

}

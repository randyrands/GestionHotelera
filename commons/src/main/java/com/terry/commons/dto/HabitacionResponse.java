package com.terry.commons.dto;

import java.math.BigDecimal;

public record HabitacionResponse(
		Long id,
		Long numero,
		String tipo,
		String descripcion,
		BigDecimal  precio,
		Long capacidad,
		String estado
		) {

}

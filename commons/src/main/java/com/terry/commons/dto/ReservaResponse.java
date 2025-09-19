package com.terry.commons.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public record ReservaResponse(
		Long id,
		Date fecha_entrada,
		Date fecha_salida,
		Integer noches,
		BigDecimal total,
		String estado,
	    String huesped,
		Set<Integer> habitaciones
		) {

}

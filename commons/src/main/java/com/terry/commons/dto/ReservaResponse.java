package com.terry.commons.dto;

import java.util.Date;
import java.util.Set;

public record ReservaResponse(
		Long id,
		Date fecha_entrada,
		Date fecha_salida,
		Integer noches,
		Double total,
		String estado,
		Set<String> idHuepedes,
		Set<String> idHabitaciones
		) {

}

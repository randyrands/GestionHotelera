package com.terry.reservaciones.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.terry.commons.controllers.CommonController;
import com.terry.commons.dto.ReservaRequest;
import com.terry.commons.dto.ReservaResponse;
import com.terry.reservaciones.services.ReservaService;



@RestController
public class ReservaController extends CommonController<ReservaRequest, ReservaResponse, ReservaService> {

	public ReservaController(ReservaService service) {
		super(service);
	}
	@GetMapping("/id-habitacion/{id}")
	boolean habitacionIsPresent(@PathVariable Long id) {
		return service.habitacionIsPresent(id);
	}
	
	@GetMapping("/id-huesped/{id}")
	boolean huespedIsPresent(@PathVariable Long id) {
		return service.huespedIsPresent(id);
	}
}



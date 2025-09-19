package com.terry.habitaciones.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.terry.commons.controllers.CommonController;
import com.terry.commons.dto.HabitacionRequest;
import com.terry.commons.dto.HabitacionResponse;
import com.terry.habitaciones.services.HabitacionService;

@RestController
public class HabitacionController extends CommonController<HabitacionRequest, HabitacionResponse, HabitacionService>{

	public HabitacionController(HabitacionService service) {
		super(service);
	}

}

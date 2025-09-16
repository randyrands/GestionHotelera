package com.terry.huespedes.controllers;
import org.springframework.web.bind.annotation.RestController;

import com.terry.commons.controllers.CommonController;
import com.terry.commons.dto.HuespedRequest;
import com.terry.commons.dto.HuespedResponse;
import com.terry.huespedes.services.HuespedService;






@RestController
public class HuespedController extends CommonController<HuespedRequest, HuespedResponse, HuespedService>{

	public HuespedController(HuespedService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

}

package com.terry.commons.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-reservaciones" )
public interface ResevaClient {
	@GetMapping("/id-habitacion/{id}")
	boolean habitacionIsPresent(@PathVariable Long id);
	
	@GetMapping("/id-huesped/{id}")
	boolean huespedIsPresent(@PathVariable Long id);
	
}

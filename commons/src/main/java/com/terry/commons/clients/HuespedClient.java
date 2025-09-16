package com.terry.commons.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.terry.commons.dto.HuespedResponse;


@FeignClient(name ="ms-huespedes")
public interface HuespedClient {
	
	@GetMapping("/{id}")
	HuespedResponse getHuespedById(@PathVariable String id);
}

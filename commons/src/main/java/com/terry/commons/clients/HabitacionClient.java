package com.terry.commons.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.terry.commons.configuration.FeignClientConfig;
import com.terry.commons.dto.HabitacionResponse;


@FeignClient(name = "ms-habitaciones",  configuration = FeignClientConfig.class)
public interface HabitacionClient {

    @GetMapping("/{id}")
    HabitacionResponse getHabitacionXById(@PathVariable Long id);

}
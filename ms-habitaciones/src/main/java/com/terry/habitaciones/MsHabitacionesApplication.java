package com.terry.habitaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.terry.habitaciones","com.terry.commons"})
public class MsHabitacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsHabitacionesApplication.class, args);
	}

}

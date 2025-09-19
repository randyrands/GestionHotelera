package com.terry.reservaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.terry.reservaciones","com.terry.commons"})
public class MsReservacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsReservacionesApplication.class, args);
	}

}

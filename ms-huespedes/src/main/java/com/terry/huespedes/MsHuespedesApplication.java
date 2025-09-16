package com.terry.huespedes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.terry.huespedes","com.terry.commons"})
public class MsHuespedesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsHuespedesApplication.class, args);
	}

}

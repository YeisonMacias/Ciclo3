package com.usa.renta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.usa.renta.model"})
@SpringBootApplication
public class RentaMaquinariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentaMaquinariaApplication.class, args);
	}

}

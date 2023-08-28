package com.codingeznghiaxpes.fullstackbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.codingeznghiaxpes.fullstackbackend.model"})
public class FullstackBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullstackBackendApplication.class, args);
	}

}

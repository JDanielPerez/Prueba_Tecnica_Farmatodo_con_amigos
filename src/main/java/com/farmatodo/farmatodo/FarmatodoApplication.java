package com.farmatodo.farmatodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FarmatodoApplication {

	public static void main(String[] args) {

		SpringApplication.run(FarmatodoApplication.class, args);
	}
	
}

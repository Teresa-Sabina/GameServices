package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RestserviceforGameApplication {

	
	public static void main(String[] args) {
		
		SpringApplication.run(RestserviceforGameApplication.class, args);
	}

}

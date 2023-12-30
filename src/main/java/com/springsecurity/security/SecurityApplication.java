package com.springsecurity.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@GetMapping(value = "/private")
	public String test(){
		return "This is an private end-point";
	}

	@GetMapping(value = "/public")
	public String publicEndpoint(){
		return "This is an public end-point";
	}
}

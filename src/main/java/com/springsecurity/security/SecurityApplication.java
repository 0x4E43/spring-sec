package com.springsecurity.security;

import com.springsecurity.security.user.UserServiceImpl;
import com.springsecurity.security.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SecurityApplication {

	@Autowired
	UserServiceImpl userServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@GetMapping(value = "/private")
	public String test(){
		return "This is an private end-point";
	}

	@GetMapping(value = "/public")
	public String publicEndpoint(){
		return userServiceImpl.generatePasswordForInitialUSer();
	}

	@GetMapping(value = "/login")
	public String loginEndpoint(){
		return "This is an loginS end-point";
	}


	@PostMapping(value = "/user/login")
	public String loginUser(@RequestBody UserVO userVO) {
		return  userServiceImpl.loginUser(userVO);
	}
}

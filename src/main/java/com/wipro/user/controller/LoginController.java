package com.wipro.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.user.dto.LoginRequest;
import com.wipro.user.dto.LoginResponse;
import com.wipro.user.dto.RegisterRequest;
import com.wipro.user.dto.RegisterResponse;
import com.wipro.user.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController

public class LoginController {
	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public LoginResponse userLogin(@RequestBody LoginRequest request) {
		System.out.println("test");
		return loginService.userLogin(request);
	}
	@PostMapping("/register")
	public RegisterResponse userRegister(@RequestBody RegisterRequest request) {
		return loginService.registerUser(request);
	}
}

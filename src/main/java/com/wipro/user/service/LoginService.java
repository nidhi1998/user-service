package com.wipro.user.service;

import org.springframework.stereotype.Service;

import com.wipro.user.dto.FetchUserResponse;
import com.wipro.user.dto.LoginRequest;
import com.wipro.user.dto.LoginResponse;
import com.wipro.user.dto.RegisterRequest;
import com.wipro.user.dto.RegisterResponse;

@Service
public interface LoginService {

	LoginResponse userLogin(LoginRequest request);

	RegisterResponse registerUser(RegisterRequest request);

	FetchUserResponse fetchUser();



}

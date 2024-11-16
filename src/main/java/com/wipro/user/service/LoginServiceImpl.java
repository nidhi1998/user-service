package com.wipro.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.user.dto.FetchUserResponse;
import com.wipro.user.dto.LoginRequest;
import com.wipro.user.dto.LoginResponse;
import com.wipro.user.dto.RegisterRequest;
import com.wipro.user.dto.RegisterResponse;
import com.wipro.user.dto.TeamMemberResponse;
import com.wipro.user.entity.TeamUserMapping;
import com.wipro.user.entity.User;
import com.wipro.user.repo.UserRepo;
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	UserRepo userRepo;
	@Override
	public LoginResponse userLogin(LoginRequest request) {
		LoginResponse response = new LoginResponse();
		try {
		User user = userRepo.findByEmail(request.getUsername());
		if(user!=null) {
			if(user.getPassword().equals(request.getPassword())) {
				response.setName(user.getName());
				response.setRole(user.getRole());
				response.setUserId(String.valueOf(user.getId()));
				response.setStatus("true");				
			}
			else {
				response.setStatus("false");
				response.setMessage("wrong password");
			}
		}
		else {
			response.setStatus("false");
			response.setMessage("user not found");
		}}
		catch(Exception e) {
			e.printStackTrace();
			response.setStatus("false");
			response.setMessage("internal server error");
		}
		return response;
	}
	@Override
	public RegisterResponse registerUser(RegisterRequest request) {
		RegisterResponse response = new RegisterResponse();
		if(request.getEmail()==null || request.getEmail().isEmpty()
				|| request.getPassword()==null || request.getPassword().isEmpty()||
				request.getUsername()==null || request.getUsername().isEmpty()||
				request.getRole()==null || request.getRole().isEmpty())
			{
			response.setMessage("all input required");
			response.setStatus("false");
			return response;
			}
		if(userRepo.findByEmail(request.getEmail())!=null)
{response.setMessage("user already exist");
response.setStatus("false");
return response;}
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole());
		user.setName(request.getUsername());
		User res = userRepo.save(user);
		if(res == null)
			{response.setMessage("not able to create user");
			response.setStatus("false");
			return response;}
		else {
			response.setMessage("created successfully");
			response.setStatus("true");
			return response;
		}
	
	
	}
	@Override
	public FetchUserResponse fetchUser() {
		FetchUserResponse response = new FetchUserResponse();
		List<User> users =  userRepo.findAllUser();
		if(users==null || users.size()==0) {
			response.setMessage("no user found");
			response.setStatus("false");
			return response;
		}	List<TeamMemberResponse> members = users.stream()
				.map(mapping -> new TeamMemberResponse(mapping.getId(), mapping.getName(),
						mapping.getRole()))
				.collect(Collectors.toList());
		response.setUsers(members);
		response.setMessage("user fetched successfully");
		response.setStatus("true");
		return response;
	}
	
}

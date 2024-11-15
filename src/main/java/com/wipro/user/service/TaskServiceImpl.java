package com.wipro.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.user.dto.CreateTaskResponse;
import com.wipro.user.entity.Task;
import com.wipro.user.entity.User;
import com.wipro.user.repo.TaskRepo;

@Service
public class TaskServiceImpl implements TaskService{
@Autowired
TaskRepo taskrepo;
@Override
	public CreateTaskResponse createtask(Task request) {
	
	CreateTaskResponse response= new CreateTaskResponse();
	
	Task res = taskrepo.save(request);
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
  
}

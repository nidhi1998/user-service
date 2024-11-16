package com.wipro.user.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.user.dto.CreateTaskResponse;
import com.wipro.user.dto.FetchTaskRequest;
import com.wipro.user.dto.FetchTaskResponse;
import com.wipro.user.dto.RegisterRequest;
import com.wipro.user.dto.RegisterResponse;
import com.wipro.user.entity.Task;
import com.wipro.user.service.LoginService;
import com.wipro.user.service.TaskService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController

public class TaskController {

	@Autowired
	TaskService taskService;
	
	@PostMapping("/task/create")
	public CreateTaskResponse createTask(@RequestBody Task request) {
		return taskService.createtask(request);
	}
	@PostMapping("/task/fetch")
	public FetchTaskResponse userRegister(@RequestBody FetchTaskRequest request) {
		return taskService.fetchTask(request);
	}
	@DeleteMapping("/task/delete/{id}")
	public CreateTaskResponse userRegister(@PathVariable Long id) {
		return taskService.deleteTask(id);
	}
	@PostMapping("/task/update")
	public CreateTaskResponse updateTask(@RequestBody Task request) {
		return taskService.updateTask(request);
	}
	
}

package com.wipro.user.service;

import org.springframework.stereotype.Service;

import com.wipro.user.dto.CreateTaskResponse;
import com.wipro.user.dto.FetchTaskRequest;
import com.wipro.user.dto.FetchTaskResponse;
import com.wipro.user.entity.Task;
@Service

public interface TaskService {

	CreateTaskResponse createtask(Task request);

	FetchTaskResponse fetchTask(FetchTaskRequest request);

	CreateTaskResponse deleteTask(Long id);

	CreateTaskResponse updateTask(Task request);

}

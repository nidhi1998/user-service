package com.wipro.user.service;

import org.springframework.stereotype.Service;

import com.wipro.user.dto.CreateTaskResponse;
import com.wipro.user.entity.Task;
@Service

public interface TaskService {

	CreateTaskResponse createtask(Task request);

}

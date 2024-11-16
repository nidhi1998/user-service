package com.wipro.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.user.dto.CreateTaskResponse;
import com.wipro.user.dto.FetchTaskRequest;
import com.wipro.user.dto.FetchTaskResponse;
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
    @Override
public FetchTaskResponse fetchTask(FetchTaskRequest request) {
	FetchTaskResponse response = new FetchTaskResponse();
	List<Task> tasks =null;
	if(request.getUserType().equals("user")) {
		if(request.getTeam()==null)
		tasks = taskrepo.findUserTask(request.getUserId());
		else
			tasks = taskrepo.findUserTeamTask(request.getUserId());
	}
	else {
		if(request.getTeam()==null)
		tasks = taskrepo.findAdminTask(request.getUserId());
		else
			{tasks = taskrepo.findAdminTeamTask(request.getUserId(),request.getTeam());
		if(tasks!=null) {
			int pending  = taskrepo.findPendingteamTask(request.getUserId(),request.getTeam());
			int inprogress = taskrepo.findInprogressTask(request.getUserId(),request.getTeam());
		    int complete=  taskrepo.findCompleteTask(request.getUserId(),request.getTeam());
		    response.setCompletedTask(String.valueOf(complete));
		    response.setInProgressTask(String.valueOf(inprogress));
		    response.setPendingTask(String.valueOf(pending));
		    int total = tasks.size();
			response.setTotalTask(String.valueOf(total));
		}
		else{	response.setMessage("no task found");
		response.setStatus("false");
		return response;}}
	}
	if(tasks.size()>0) {
		response.setTasks(tasks);
		response.setMessage("task fetched successfully");
		response.setStatus("true");
		return response;
	}
	else {
		response.setMessage("no task found");
		response.setStatus("false");
		return response;
	}
	
}
	@Override
	public CreateTaskResponse deleteTask(Long id) {
		CreateTaskResponse response = new CreateTaskResponse();
		boolean task = taskrepo.existsById(id);
		if(!task) {
			response.setStatus("false");
			response.setMessage("task not found");
			// TODO Auto-generated method stub
			return response;
		}
		taskrepo.deleteById(id);
		response.setStatus("true");
		response.setMessage("deleted successfully");
		// TODO Auto-generated method stub
		return response;
	}
	@Override
	public CreateTaskResponse updateTask(Task request) {
		CreateTaskResponse response = new CreateTaskResponse();
		boolean task = taskrepo.existsById(request.getId());
		if(!task) {
			response.setStatus("false");
			response.setMessage("task not found");
			// TODO Auto-generated method stub
			return response;
		}
		Task res = taskrepo.save(request);
		if(res==null) {
			response.setStatus("false");
			response.setMessage("task update failed ");
			// TODO Auto-generated method stub
			return response;
		}
		response.setStatus("true");
		response.setMessage("task update success ");
		// TODO Auto-generated method stub
		return response;
		
	}
  
}

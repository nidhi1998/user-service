package com.wipro.user.dto;

import java.util.List;

import com.wipro.user.entity.Task;

public class FetchTaskResponse {
private List<Task> tasks;
private String totalTask;
private String pendingTask;
private String inProgressTask;
private String completedTask;
private String status;
private String message;

public String getTotalTask() {
	return totalTask;
}
public void setTotalTask(String totalTask) {
	this.totalTask = totalTask;
}
public String getPendingTask() {
	return pendingTask;
}
public void setPendingTask(String pendingTask) {
	this.pendingTask = pendingTask;
}
public String getInProgressTask() {
	return inProgressTask;
}
public void setInProgressTask(String inProgressTask) {
	this.inProgressTask = inProgressTask;
}
public String getCompletedTask() {
	return completedTask;
}
public void setCompletedTask(String completedTask) {
	this.completedTask = completedTask;
}
public List<Task> getTasks() {
	return tasks;
}
public void setTasks(List<Task> tasks) {
	this.tasks = tasks;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}


}

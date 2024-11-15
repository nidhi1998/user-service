package com.wipro.user.dto;

import java.util.List;

public class FetchTeamResponse {

	private List<TeamResponse> teams;
	private String status;
	private String message;
	private String totalTask;
	private String pendingTask;
	private String inProgressTask;
	private String completedTask;
	public List<TeamResponse> getTeams() {
		return teams;
	}
	public void setTeams(List<TeamResponse> teams) {
		this.teams = teams;
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
	

}

package com.wipro.user.dto;

import com.wipro.user.entity.Team;

public class TeamResponse {

	private Team team;
	private String totalTask;
	private String pendingTask;
	private String inProgressTask;
	private String completedTask;
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
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

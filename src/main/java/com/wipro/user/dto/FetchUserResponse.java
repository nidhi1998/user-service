package com.wipro.user.dto;

import java.util.List;

public class FetchUserResponse {
	private List<TeamMemberResponse> users;
	private String message;
	private String status;
	
	
	public List<TeamMemberResponse> getUsers() {
		return users;
	}
	public void setUsers(List<TeamMemberResponse> users) {
		this.users = users;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}

package com.wipro.user.dto;

import java.util.List;

public class FetchTeamMemberResponse {

	private List<TeamMemberResponse1> members;
	private String message;
	private String status;
	public List<TeamMemberResponse1> getMembers() {
		return members;
	}
	public void setMembers(List<TeamMemberResponse1> members) {
		this.members = members;
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

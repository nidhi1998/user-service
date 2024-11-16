package com.wipro.user.cdto;

import java.util.List;

import com.wipro.user.dto.TeamMemberResponse;

public class FetchTeamMemberResponse {

	private List<TeamMemberResponse> members;
	private String message;
	private String status;
	public List<TeamMemberResponse> getMembers() {
		return members;
	}
	public void setMembers(List<TeamMemberResponse> members) {
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

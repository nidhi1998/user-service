package com.wipro.user.dto;

public class FetchTeamRequest {
private String userId;
private String userType;

public String getUserType() {
	return userType;
}

public void setUserType(String userType) {
	this.userType = userType;
}

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

}

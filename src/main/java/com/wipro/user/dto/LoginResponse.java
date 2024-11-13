package com.wipro.user.dto;

public class LoginResponse {
private String userId;
private String role;
private String name;
private String status;
private String message;

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
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}

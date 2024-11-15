package com.wipro.user.dto;

public class CreateTaskResponse {

	private String taskId;
	
		private String status; 
		private String message;
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public String getTaskId() {
			return taskId;
		}
		public void setTaskId(String taskId) {
			this.taskId = taskId;
		}
		public void setMessage(String message) {
			this.message = message;
		}

		}

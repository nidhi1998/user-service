package com.wipro.user.dto;

public class TeamUserMappingRequest {
	 private Long teamId;
	    private Long userId;
		public Long getTeamId() {
			return teamId;
		}
		public void setTeamId(Long teamId) {
			this.teamId = teamId;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
}

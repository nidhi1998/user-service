package com.wipro.user.service;

import org.springframework.stereotype.Service;

import com.wipro.user.dto.CreateTaskResponse;
import com.wipro.user.dto.CreateTeamResponse;
import com.wipro.user.dto.FetchTeamMemberRequest;
import com.wipro.user.dto.FetchTeamMemberResponse;
import com.wipro.user.dto.FetchTeamRequest;
import com.wipro.user.dto.FetchTeamResponse;
import com.wipro.user.dto.TeamUserMappingRequest;
import com.wipro.user.dto.TeamUserMappingResponse;
import com.wipro.user.entity.Team;

@Service
public interface TeamService {

	CreateTeamResponse createTeam(Team request);

	FetchTeamResponse fetchTeam(FetchTeamRequest request);

	TeamUserMappingResponse addTeamMember(TeamUserMappingRequest request);

	FetchTeamMemberResponse fetchTeamMembers(FetchTeamMemberRequest request);

	CreateTeamResponse deleteTeam(Long teamId);

	CreateTaskResponse updateTeam(Team request);

}

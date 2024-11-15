package com.wipro.user.service;

import org.springframework.stereotype.Service;

import com.wipro.user.dto.CreateTeamResponse;
import com.wipro.user.dto.FetchTeamRequest;
import com.wipro.user.dto.FetchTeamResponse;
import com.wipro.user.entity.Team;

@Service
public interface TeamService {

	CreateTeamResponse createTeam(Team request);

	FetchTeamResponse fetchTeam(FetchTeamRequest request);

}

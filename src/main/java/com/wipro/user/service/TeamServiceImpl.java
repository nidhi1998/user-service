package com.wipro.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.user.dto.CreateTeamResponse;
import com.wipro.user.dto.FetchTeamRequest;
import com.wipro.user.dto.FetchTeamResponse;
import com.wipro.user.dto.TeamResponse;
import com.wipro.user.entity.Team;
import com.wipro.user.repo.TaskRepo;
import com.wipro.user.repo.TeamRepo;

@Service
public class TeamServiceImpl implements TeamService{

	@Autowired
	TeamRepo teamRepo;
	@Autowired
	TaskRepo taskRepo;
	@Override
	public CreateTeamResponse createTeam(Team request) {
		CreateTeamResponse response = new CreateTeamResponse();
		if(request.getName()==null || request.getSize()==null) {
			response.setMessage("name and size are required");
			response.setStatus("false");
			return response;
		}
		Team team = teamRepo.findByName(request.getName());
		if(team!=null) {
			response.setMessage("team already exist");
			response.setStatus("false");
			return response;
		}
		else {
			response.setMessage("team created successfully");
			response.setStatus("true");
			return response;
		}
		
	}
	@Override
	public FetchTeamResponse fetchTeam(FetchTeamRequest request) {
		FetchTeamResponse response = new FetchTeamResponse();
		List<Team> teams = teamRepo.findAllByAdmin(request.getUserId());
		if(teams==null) {
			response.setMessage("no team found");
			response.setStatus("false");
			return response;
		}
		List<TeamResponse> teamResponse = new ArrayList<>();;
		for(Team t:teams) {
			TeamResponse tt = new TeamResponse();
			tt.setTeam(t);
			int pending  = taskRepo.findPendingteamTask(request.getUserId(),String.valueOf(t.getId()));
			int inprogress = taskRepo.findInprogressTask(request.getUserId(),String.valueOf(t.getId()));
		    int complete=  taskRepo.findCompleteTask(request.getUserId(),String.valueOf(t.getId()));
		    tt.setCompletedTask(String.valueOf(complete));
		    tt.setCompletedTask(String.valueOf(complete));
		    tt.setInProgressTask(String.valueOf(inprogress));
		    tt.setPendingTask(String.valueOf(pending));
		    int total = pending+inprogress+complete;
			tt.setTotalTask(String.valueOf(total));
			teamResponse.add(tt);
		}response.setTeams(teamResponse);
		response.setMessage("fetched team successfully");
		response.setStatus("true");
		return response;
	}

}

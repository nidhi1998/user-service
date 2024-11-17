package com.wipro.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.user.cdto.FetchTeamMemberResponse;
import com.wipro.user.dto.CreateTeamResponse;
import com.wipro.user.dto.FetchTeamMemberRequest;
import com.wipro.user.dto.FetchTeamRequest;
import com.wipro.user.dto.FetchTeamResponse;
import com.wipro.user.dto.TeamMemberResponse;
import com.wipro.user.dto.TeamResponse;
import com.wipro.user.dto.TeamUserMappingRequest;
import com.wipro.user.dto.TeamUserMappingResponse;
import com.wipro.user.entity.Team;
import com.wipro.user.entity.TeamUserMapping;
import com.wipro.user.entity.User;
import com.wipro.user.repo.TaskRepo;
import com.wipro.user.repo.TeamRepo;
import com.wipro.user.repo.TeamUserMappingRepo;
import com.wipro.user.repo.UserRepo;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamRepo teamRepo;
	@Autowired
	TaskRepo taskRepo;
	@Autowired
	TeamUserMappingRepo mappingRepo;
	@Autowired
	UserRepo userRepo;

	@Override
	public CreateTeamResponse createTeam(Team request) {
		CreateTeamResponse response = new CreateTeamResponse();
		if (request.getName() == null || request.getSize() == null) {
			response.setMessage("name and size are required");
			response.setStatus("false");
			return response;
		}
		Team team = teamRepo.findByName(request.getName());
		if (team != null) { 
			response.setMessage("team already exist");
			response.setStatus("false");
			return response;
		} else { teamRepo.save(request);
			response.setMessage("team created successfully");
			response.setStatus("true");
			return response;
		}

	}

	@Override
	public FetchTeamResponse fetchTeam(FetchTeamRequest request) {
		FetchTeamResponse response = new FetchTeamResponse();
		List<Team> teams=null;
		if(request.getUserType().equalsIgnoreCase("user"))
		teams = teamRepo.findAllByAdmin(request.getUserId());
		else {
			teams = teamRepo.findAllforAdminTeams(request.getUserId());
		}
		if (teams == null) {
			response.setMessage("no team found");
			response.setStatus("false");
			return response;
		}
		List<TeamResponse> teamResponse = new ArrayList<>();
		;
		for (Team t : teams) {
			TeamResponse tt = new TeamResponse();
			tt.setTeam(t);
			int pending = taskRepo.findPendingteamTask(request.getUserId(), String.valueOf(t.getId()));
			int inprogress = taskRepo.findInprogressTask(request.getUserId(), String.valueOf(t.getId()));
			int complete = taskRepo.findCompleteTask(request.getUserId(), String.valueOf(t.getId()));
			tt.setCompletedTask(String.valueOf(complete));
			tt.setCompletedTask(String.valueOf(complete));
			tt.setInProgressTask(String.valueOf(inprogress));
			tt.setPendingTask(String.valueOf(pending));
			int total = pending + inprogress + complete;
			tt.setTotalTask(String.valueOf(total));
			teamResponse.add(tt);
		}
		response.setTeams(teamResponse);
		response.setMessage("fetched team successfully");
		response.setStatus("true");
		return response;
	}

	@Override
	public TeamUserMappingResponse addTeamMember(TeamUserMappingRequest request) {
		TeamUserMappingResponse response = new TeamUserMappingResponse();
		Team team = teamRepo.findByIdTeam(request.getTeamId());
		if (team == null) {
			response.setMessage("no team found");
			response.setStatus("false");
			return response;
		}
		List<TeamUserMapping> mappings = mappingRepo.findByTeamId(request.getTeamId());
		if (team.getSize().equals(String.valueOf(mappings.size()))) {
			response.setMessage("team is full");
			response.setStatus("false");
			return response;
		}
		User user = userRepo.findByIdUser(request.getUserId());
		if (user == null) {
			response.setMessage("no user found");
			response.setStatus("false");
			return response;
		}
		TeamUserMapping userMember = mappingRepo.findByTeamIdandUserId(request.getTeamId(), request.getUserId());
		if (userMember != null) {
			response.setMessage("member already present");
			response.setStatus("false");
			return response;
		}
		TeamUserMapping mapping = new TeamUserMapping();
		mapping.setTeam(team);
		mapping.setUser(user);

		mappingRepo.save(mapping);
		response.setMessage("member added successfully");
		response.setStatus("true");
		return response;

	}

	@Override
	public FetchTeamMemberResponse fetchTeamMembers(FetchTeamMemberRequest request) {
		FetchTeamMemberResponse response = new FetchTeamMemberResponse();
		List<TeamUserMapping> mappings = mappingRepo.findByTeamId(request.getTeamId());
		if (mappings == null || mappings.size()==0) {
			response.setMessage("no member found ");
			response.setStatus("true");
			return response;
		}
		List<TeamMemberResponse> members = mappings.stream()
				.map(mapping -> new TeamMemberResponse(mapping.getUser().getId(), mapping.getUser().getName(),
						mapping.getUser().getRole()))
				.collect(Collectors.toList());
		response.setMessage("members fetched successfully ");
		response.setStatus("true");
		response.setMembers(members);
		return response;

	}

}

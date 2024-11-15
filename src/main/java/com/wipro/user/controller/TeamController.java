package com.wipro.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.user.dto.CreateTeamResponse;
import com.wipro.user.dto.FetchTeamRequest;
import com.wipro.user.dto.FetchTeamResponse;

import com.wipro.user.entity.Team;
import com.wipro.user.service.TeamService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController

public class TeamController {
	@Autowired
	TeamService teamService;
	
	@PostMapping("/team/create")
	public CreateTeamResponse createTeam(@RequestBody Team request) {
		return teamService.createTeam(request);
	}
	@PostMapping("/team/fetch")
	public FetchTeamResponse userRegister(@RequestBody FetchTeamRequest request) {
		return teamService.fetchTeam(request);
	}
	
}

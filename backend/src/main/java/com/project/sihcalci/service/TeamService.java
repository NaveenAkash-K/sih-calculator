package com.project.sihcalci.service;

import com.project.sihcalci.models.Team;
import com.project.sihcalci.repositories.TeamRepository;
import com.project.sihcalci.response.TeamResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamResponse> getTeams(){
        List<TeamResponse> teamResponses = new ArrayList<>();
        List<Team> teams = teamRepository.findAll();
        for (Team team : teams) {
            teamResponses.add(new TeamResponse(team));
        }
        return teamResponses;
    }
}

package com.league.jogobonito.controller;


import com.league.jogobonito.domain.Team;
import com.league.jogobonito.repository.TeamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    private TeamRepository teamRepository;
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping(value = "/obtenerTeams")
    public List<Team> obtenerTeams() {
        return teamRepository.findAll();
    }
}






package com.league.jogobonito.controller;

import com.league.jogobonito.domain.Team;
import com.league.jogobonito.dto.TeamDTO;
import com.league.jogobonito.mapper.TeamMapper;
import com.league.jogobonito.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping(value = "/obtenerTeams")
    public List<TeamDTO> obtenerTeams() {

        List<Team>listaTeams = teamRepository.findAll();
        List<TeamDTO> teamsDTO = TeamMapper.domainToDTOList(listaTeams);

        return teamsDTO;
    }


    @PostMapping(value = "/crearNuevoTeam")
    public ResponseEntity<TeamDTO> crearNuevoTeam(@RequestBody TeamDTO teamDTO) {
        TeamDTO teamDTOResponse = null ;

        Team team = TeamMapper.dtoToDomain(teamDTO);
        team = teamRepository.save(team);

        teamDTOResponse = TeamMapper.domainToDT0(team);
        return new ResponseEntity<>(teamDTOResponse, HttpStatus.CREATED);
    }
}






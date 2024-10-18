package com.league.jogobonito.controller;

import com.league.jogobonito.dto.TeamDTO;
import com.league.jogobonito.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/team")
public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping(value = "/guardarNuevoTeam")
    public ResponseEntity<TeamDTO> guardarNuevoTeam(@RequestBody TeamDTO teamDTO) throws Exception {
        TeamDTO teamResponse = teamService.guardarNuevoTeam(teamDTO);
        return new ResponseEntity<>(teamResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerTeams")
    public List<TeamDTO> obtenerTeams(){
        return teamService.obtenerTeams();
    }

    @GetMapping("/buscarTeamPorId/{id}")
    public ResponseEntity<TeamDTO> buscarTeamPorId (Integer id)throws Exception {
        TeamDTO teamResponse = teamService.buscarTeamPorId(id);
        return new ResponseEntity<>(teamResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarTeam")
    public ResponseEntity<TeamDTO> modificarTeam(@RequestBody TeamDTO teamDTO) throws Exception {
        TeamDTO teamResponse = teamService.modificarTeam(teamDTO);
        return new ResponseEntity<>(teamResponse, HttpStatus.CREATED);
    }

}






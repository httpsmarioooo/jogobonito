package com.league.jogobonito.service;

import com.league.jogobonito.dto.TeamDTO;

import java.util.List;

public interface TeamService {
    TeamDTO guardarNuevoTeam(TeamDTO teamDTO) throws Exception;
    TeamDTO buscarTeamPorId(Integer id) throws Exception;
    TeamDTO buscarEquipoPorInicial(String initial) throws Exception;
    TeamDTO modificarTeam(TeamDTO teamDTO) throws Exception;
    List<TeamDTO> obtenerTeams();
}

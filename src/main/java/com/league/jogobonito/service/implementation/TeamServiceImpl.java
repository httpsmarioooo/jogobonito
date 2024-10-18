package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.Team;
import com.league.jogobonito.dto.TeamDTO;
import com.league.jogobonito.mapper.TeamMapper;
import com.league.jogobonito.repository.TeamRepository;
import com.league.jogobonito.service.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public TeamDTO guardarNuevoTeam(TeamDTO teamDTO) throws Exception {

        if(teamDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (teamDTO.getName() == null || teamDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (teamDTO.getCity() == null || teamDTO.getCity().isBlank()) {
            throw new Exception("La ciudad no debe ser nulo o vacío");
        }

        Team team = TeamMapper.dtoToDomain(teamDTO);
        team = teamRepository.save(team);
        return TeamMapper.domainToDT0(team);
    }

    @Override
    @Transactional(readOnly = true)
    public TeamDTO buscarTeamPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        Team team = teamRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el jugador con el id" +id));
        return TeamMapper.domainToDT0(team);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public TeamDTO modificarTeam(TeamDTO teamDTO) throws Exception {
        if(teamDTO.getId() == null) {
            throw new Exception("El id no puede ser nulo");
        }

        if (teamDTO.getName() == null || teamDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (teamDTO.getCity() == null || teamDTO.getCity().isBlank()) {
            throw new Exception("La ciudad no debe ser nulo o vacío");
        }

        Team team = TeamMapper.dtoToDomain(teamDTO);
        team = teamRepository.save(team);
        return TeamMapper.domainToDT0(team);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TeamDTO> obtenerTeams() {
        List<Team>listaTeams = teamRepository.findAll();
        List<TeamDTO>teamDTO = TeamMapper.domainToDTOList(listaTeams);
        return TeamMapper.domainToDTOList(listaTeams);
    }
}

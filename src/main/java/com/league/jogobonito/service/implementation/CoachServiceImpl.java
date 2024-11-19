package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.Coach;
import com.league.jogobonito.domain.Team;
import com.league.jogobonito.dto.CoachDTO;
import com.league.jogobonito.mapper.CoachMapper;
import com.league.jogobonito.repository.CoachRepository;
import com.league.jogobonito.repository.TeamRepository;
import com.league.jogobonito.service.CoachService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;
    private final TeamRepository teamRepository;

    public CoachServiceImpl(CoachRepository coachRepository, TeamRepository teamRepository) {
        this.coachRepository = coachRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public CoachDTO guardarNuevoCoach(CoachDTO coachDTO) throws Exception {

        if(coachDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (coachDTO.getName() == null || coachDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if(coachDTO.getTeamId() == null) {
            throw new Exception("El TeamId no debe ser nulo");
        }

        Coach coach = CoachMapper.dtoToDomain(coachDTO);
        Team team = teamRepository.getReferenceById(coachDTO.getTeamId());

        if (team == null){
            throw new Exception("El Team no existe");
        }

        coach.setTeam(team);
        coach = coachRepository.save(coach);
        return CoachMapper.domainToDto(coach);
    }

    @Override
    @Transactional(readOnly = true)
    public CoachDTO buscarCoachPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        Coach coach = coachRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el Coach con el id " +id));
        return CoachMapper.domainToDto(coach);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public CoachDTO modificarCoach(CoachDTO coachDTO) throws Exception {
        if(coachDTO.getId() == null) {
            throw new Exception("El id no puede ser nulo");
        }

        if (coachDTO.getName() == null || coachDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if(coachDTO.getTeamId() == null) {
            throw new Exception("El TeamId no debe ser nulo");
        }

        Coach coach = CoachMapper.dtoToDomain(coachDTO);
        Team team = teamRepository.getReferenceById(coachDTO.getTeamId());

        if (team == null){
            throw new Exception("El Team no existe");
        }

        coach.setTeam(team);
        coach = coachRepository.save(coach);

        return CoachMapper.domainToDto(coach);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CoachDTO> obtenerCoaches() {
        List<Coach>listaCoaches = coachRepository.findAll();
        List<CoachDTO>coachDTO = CoachMapper.domainToDTOList(listaCoaches);
        return CoachMapper.domainToDTOList(listaCoaches);
    }
}

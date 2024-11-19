package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.Standing;
import com.league.jogobonito.domain.Team;
import com.league.jogobonito.dto.StandingDTO;
import com.league.jogobonito.mapper.StandingMapper;
import com.league.jogobonito.mapper.TeamMapper;
import com.league.jogobonito.repository.StandingRepository;
import com.league.jogobonito.repository.TeamRepository;
import com.league.jogobonito.service.StandingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StandingServiceImpl implements StandingService {

    private final StandingRepository standingRepository;
    private final TeamRepository teamRepository;

    public StandingServiceImpl(StandingRepository standingRepository, TeamRepository teamRepository) {
        this.standingRepository = standingRepository;
        this.teamRepository = teamRepository;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public StandingDTO guardarNuevoStanding(StandingDTO standingDTO) throws Exception {
        if(standingDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (standingDTO.getPoints() == null ) {
            throw new Exception("Los puntos no debe ser nulo o vacío");
        }

        if (standingDTO.getGoalsFor() == null ) {
            throw new Exception("Los goles for no debe ser nulo o vacío");
        }

        if (standingDTO.getGoalsAgainst() == null ) {
            throw new Exception("Los goles against no debe ser nulo o vacío");
        }

        if(standingDTO.getTeamId() == null) {
            throw new Exception("El TeamId no debe ser nulo");
        }

        Standing standing = StandingMapper.dtoToDomain(standingDTO);
        Team team = teamRepository.getReferenceById(standingDTO.getTeamId());


        if (team == null){
            throw new Exception("El Team no existe");
        }

        standing.setTeam(team);
        standing = standingRepository.save(standing);
        return StandingMapper.domainToDto(standing);
    }

    @Override
    @Transactional(readOnly = true)
    public StandingDTO buscarStandingPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        Standing standing = standingRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el Standing con el id " +id));
        return StandingMapper.domainToDto(standing);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public StandingDTO modificarStanding(StandingDTO standingDTO) throws Exception {
        if(standingDTO.getId() == null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (standingDTO.getPoints() == null ) {
            throw new Exception("Los puntos no debe ser nulo o vacío");
        }

        if (standingDTO.getGoalsFor() == null ) {
            throw new Exception("Los goles for no debe ser nulo o vacío");
        }

        if (standingDTO.getGoalsAgainst() == null ) {
            throw new Exception("Los goles against no debe ser nulo o vacío");
        }

        if(standingDTO.getTeamId() == null) {
            throw new Exception("El TeamId no debe ser nulo");
        }

        Standing standing = StandingMapper.dtoToDomain(standingDTO);
        Team team = teamRepository.getReferenceById(standingDTO.getTeamId());


        if (team == null){
            throw new Exception("El Team no existe");
        }

        standing.setTeam(team);
        standing = standingRepository.save(standing);
        return StandingMapper.domainToDto(standing);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StandingDTO> obtenerStandings() {
        List<Standing>listaStandings = standingRepository.findAll();
        List<StandingDTO>standingsDTO = StandingMapper.domainToDTOList(listaStandings);
        return StandingMapper.domainToDTOList(listaStandings);
    }
}

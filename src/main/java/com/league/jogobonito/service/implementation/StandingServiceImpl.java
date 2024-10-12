package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.Standing;
import com.league.jogobonito.domain.Team;
import com.league.jogobonito.dto.StandingDTO;
import com.league.jogobonito.mapper.StandingMapper;
import com.league.jogobonito.repository.StandingRepository;
import com.league.jogobonito.repository.TeamRepository;
import com.league.jogobonito.service.StandingService;
import org.springframework.stereotype.Service;

@Service
public class StandingServiceImpl implements StandingService {

    private final StandingRepository standingRepository;
    private final TeamRepository teamRepository;

    public StandingServiceImpl(StandingRepository standingRepository, TeamRepository teamRepository) {
        this.standingRepository = standingRepository;
        this.teamRepository = teamRepository;
    }

    @Override
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
}

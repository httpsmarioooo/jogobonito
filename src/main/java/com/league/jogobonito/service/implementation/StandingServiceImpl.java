package com.league.jogobonito.service.implementation;

import com.league.jogobonito.dto.StandingDTO;
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

        //Hacer las validaciones correspondientes, luego de solucionar la duda en el mapper

        return null;
    }

}

package com.league.jogobonito.service;

import com.league.jogobonito.dto.StandingDTO;
import java.util.List;

public interface StandingService {
    StandingDTO guardarNuevoStanding(StandingDTO standingDTO) throws Exception;
    StandingDTO buscarStandingPorId(Integer id) throws Exception;
    StandingDTO modificarStanding(StandingDTO standingDTO) throws Exception;
    List<StandingDTO> obtenerStandings();
}



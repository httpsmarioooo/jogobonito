package com.league.jogobonito.service;

import com.league.jogobonito.dto.MatchEventDTO;
import com.league.jogobonito.dto.PlayerDTO;

import java.util.List;

public interface MatchEventService {
    MatchEventDTO guardarNuevoMatchEvent (MatchEventDTO matchEventDTO) throws Exception;
    MatchEventDTO buscarMatchEventPorId(Integer id) throws Exception;
    MatchEventDTO modificarMatchEvent(MatchEventDTO matchEventDTO) throws Exception;
    List<MatchEventDTO> obtenerMatchEvents();
}

package com.league.jogobonito.service;

import com.league.jogobonito.dto.MatchEventDTO;

import java.util.List;

public interface MatchEventService {
    MatchEventDTO guardarNuevoMatchEvent (MatchEventDTO matchEventDTO) throws Exception;
    MatchEventDTO buscarMatchEventPorId(Integer Id) throws Exception;
    List<MatchEventDTO> obtenerMatchEvents();

}

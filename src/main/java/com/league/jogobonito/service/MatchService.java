package com.league.jogobonito.service;

import com.league.jogobonito.dto.MatchDTO;

import java.util.List;

public interface MatchService {
    MatchDTO guardarNuevoMatch(MatchDTO matchDTO) throws Exception;
    MatchDTO buscarMatchPorId(Integer Id) throws Exception;
    MatchDTO modificarMatch(MatchDTO playerDTO) throws Exception;
    List<MatchDTO> obtenerMatches();

}

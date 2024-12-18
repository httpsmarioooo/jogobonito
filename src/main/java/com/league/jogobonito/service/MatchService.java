package com.league.jogobonito.service;

import com.league.jogobonito.dto.MatchDTO;
import java.util.List;

public interface MatchService {
    MatchDTO guardarNuevoMatch(MatchDTO matchDTO) throws Exception;
    MatchDTO buscarMatchPorId(Integer id) throws Exception;
    MatchDTO modificarMatch(MatchDTO MatchDTO) throws Exception;
    List<MatchDTO> obtenerMatches();
}

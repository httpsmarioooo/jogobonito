package com.league.jogobonito.service;

import com.league.jogobonito.dto.MatchDTO;

public interface MatchService {
    MatchDTO guardarNuevoMatch(MatchDTO matchDTO) throws Exception;
}

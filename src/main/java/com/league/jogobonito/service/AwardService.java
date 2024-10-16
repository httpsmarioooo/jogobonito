package com.league.jogobonito.service;

import com.league.jogobonito.dto.AwardDTO;
import com.league.jogobonito.dto.PlayerDTO;

public interface AwardService {
    AwardDTO guardarNuevoAward(AwardDTO awardDTO) throws Exception;
    AwardDTO buscarAwardPorId(Integer id) throws Exception;
    AwardDTO modificarAward(AwardDTO awardDTO) throws Exception;
}

package com.league.jogobonito.service;

import com.league.jogobonito.dto.AwardDTO;
import com.league.jogobonito.dto.PlayerDTO;

import java.util.List;

public interface AwardService {
    AwardDTO guardarNuevoAward(AwardDTO awardDTO) throws Exception;
    AwardDTO buscarAwardPorId(Integer id) throws Exception;
    AwardDTO modificarAward(AwardDTO awardDTO) throws Exception;
    List<AwardDTO> obtenerAwards();

}

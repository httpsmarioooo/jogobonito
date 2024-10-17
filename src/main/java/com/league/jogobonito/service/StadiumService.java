package com.league.jogobonito.service;

import com.league.jogobonito.dto.StadiumDTO;

public interface StadiumService {
    StadiumDTO guardarNuevoStadium(StadiumDTO stadiumDTO) throws Exception;
    StadiumDTO buscarStadiumPorId(Integer id) throws Exception;
    StadiumDTO modificarStadium(StadiumDTO stadiumDTO) throws Exception;
}

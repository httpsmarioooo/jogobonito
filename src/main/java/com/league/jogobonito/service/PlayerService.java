package com.league.jogobonito.service;

import com.league.jogobonito.dto.PlayerDTO;

public interface PlayerService {
    PlayerDTO guardarNuevoPlayer(PlayerDTO playerDTO) throws Exception;
    PlayerDTO buscarPlayerPorId(Integer id) throws Exception;
    PlayerDTO modificarPlayer(PlayerDTO playerDTO) throws Exception;
}

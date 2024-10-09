package com.league.jogobonito.service;

import com.league.jogobonito.dto.PlayerDTO;

public interface PlayerService {
    PlayerDTO guardarNuevoPlayer(PlayerDTO playerDTO) throws Exception;
}

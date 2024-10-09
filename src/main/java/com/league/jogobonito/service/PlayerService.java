package com.league.jogobonito.service;

import com.league.jogobonito.dto.PlayerDTO;

import java.sql.SQLException;

public interface PlayerService {
    PlayerDTO guardarNuevoPlayer(PlayerDTO playerDTO) throws Exception;
}

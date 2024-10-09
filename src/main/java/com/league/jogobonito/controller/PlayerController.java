package com.league.jogobonito.controller;

import com.league.jogobonito.dto.PlayerDTO;
import com.league.jogobonito.repository.PlayerRepository;
import com.league.jogobonito.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerRepository playerRepository;
    private PlayerService playerService;

    public PlayerController(PlayerRepository playerRepository, PlayerService playerService) {
        this.playerRepository = playerRepository;
        this.playerService = playerService;
    }


    @PostMapping(value = "/guardarNuevoPlayer")
    public ResponseEntity<PlayerDTO> guardarNuevoPlayer(@RequestBody PlayerDTO playerDTO) throws Exception {
        PlayerDTO playerResponse = playerService.guardarNuevoPlayer(playerDTO);
        return new ResponseEntity<>(playerResponse, HttpStatus.CREATED);
    }
}

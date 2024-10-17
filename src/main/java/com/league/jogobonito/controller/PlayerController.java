package com.league.jogobonito.controller;

import com.league.jogobonito.domain.Player;
import com.league.jogobonito.domain.Stadium;
import com.league.jogobonito.dto.PlayerDTO;
import com.league.jogobonito.mapper.PlayerMapper;
import com.league.jogobonito.mapper.StadiumMapper;
import com.league.jogobonito.repository.PlayerRepository;
import com.league.jogobonito.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(value = "/guardarNuevoPlayer")
    public ResponseEntity<PlayerDTO> guardarNuevoPlayer(@RequestBody PlayerDTO playerDTO) throws Exception {
        PlayerDTO playerResponse = playerService.guardarNuevoPlayer(playerDTO);
        return new ResponseEntity<>(playerResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerPlayers")
    public List<PlayerDTO>obtenerPlayers(){
        return playerService.obtenerPlayers();
    }

    @GetMapping("/buscarPlayerPorId/{id}")
    public ResponseEntity<PlayerDTO> buscarPlayerPorId (Integer id)throws Exception {
        PlayerDTO playerResponse = playerService.buscarPlayerPorId(id);
        return new ResponseEntity<>(playerResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarPlayer")
    public ResponseEntity<PlayerDTO> modificarPlayer(@RequestBody PlayerDTO playerDTO) throws Exception {
        PlayerDTO playerResponse = playerService.modificarPlayer(playerDTO);
        return new ResponseEntity<>(playerResponse, HttpStatus.CREATED);
    }
}

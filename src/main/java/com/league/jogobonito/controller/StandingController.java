package com.league.jogobonito.controller;

import com.league.jogobonito.dto.StandingDTO;
import com.league.jogobonito.service.StandingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/standing")
public class StandingController {

    private StandingService standingService;

    public StandingController(StandingService standingService) {
        this.standingService = standingService;
    }

    @PostMapping(value = "/guardarNuevoStanding")
    public ResponseEntity<StandingDTO> guardarNuevoStanding(@RequestBody StandingDTO standingDTO) throws Exception {
        StandingDTO standingResponse = standingService.guardarNuevoStanding(standingDTO);
        return new ResponseEntity<>(standingResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerStandings")
    public List<StandingDTO> obtenerStandings(){
        return standingService.obtenerStandings();
    }

    @GetMapping("/buscarStandingPorId/{id}")
    public ResponseEntity<StandingDTO> buscarStandingPorId (Integer id)throws Exception {
        StandingDTO standingResponse = standingService.buscarStandingPorId(id);
        return new ResponseEntity<>(standingResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarStanding")
    public ResponseEntity<StandingDTO> modificarStanding(@RequestBody StandingDTO standingDTO) throws Exception {
        StandingDTO standingResponse = standingService.modificarStanding(standingDTO);
        return new ResponseEntity<>(standingResponse, HttpStatus.CREATED);
    }

}

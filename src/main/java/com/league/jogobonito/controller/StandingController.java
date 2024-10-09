package com.league.jogobonito.controller;

import com.league.jogobonito.dto.StandingDTO;
import com.league.jogobonito.repository.StandingRepository;
import com.league.jogobonito.service.StandingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/standing")
public class StandingController {

    private StandingRepository standingRepository;
    private StandingService standingService;

    public StandingController(StandingRepository standingRepository, StandingService standingService) {
        this.standingRepository = standingRepository;
        this.standingService = standingService;
    }

    @PostMapping(value = "/guardarNuevoStanding")
    public ResponseEntity<StandingDTO> guardarNuevoStanding(@RequestBody StandingDTO standingDTO) throws Exception {
        StandingDTO standingResponse = standingService.guardarNuevoStanding(standingDTO);
        return new ResponseEntity<>(standingResponse, HttpStatus.CREATED);
    }

}

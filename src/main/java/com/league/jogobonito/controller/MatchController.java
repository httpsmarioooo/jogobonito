package com.league.jogobonito.controller;

import com.league.jogobonito.dto.MatchDTO;
import com.league.jogobonito.repository.MatchRepository;
import com.league.jogobonito.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    private MatchRepository matchRepository;
    private MatchService matchService;

    public MatchController(MatchRepository matchRepository, MatchService matchService) {
        this.matchRepository = matchRepository;
        this.matchService = matchService;
    }
    @PostMapping(value = "/guardarNuevoMatch")
    public ResponseEntity<MatchDTO> guardarNuevoMatch(@RequestBody MatchDTO matchDTO) throws Exception {
        MatchDTO matchResponse = matchService.guardarNuevoMatch(matchDTO);
        return new ResponseEntity<>(matchResponse, HttpStatus.CREATED);
    }

}

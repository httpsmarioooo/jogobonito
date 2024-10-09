package com.league.jogobonito.controller;

import com.league.jogobonito.dto.CoachDTO;
import com.league.jogobonito.repository.CoachRepository;
import com.league.jogobonito.service.CoachService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/coach")
public class CoachController {

    private CoachRepository coachRepository;
    private CoachService coachService;

    public CoachController(CoachRepository coachRepository, CoachService coachService) {
        this.coachRepository = coachRepository;
        this.coachService = coachService;
    }

    @PostMapping(value = "/guardarNuevoCoach")
    public ResponseEntity<CoachDTO> guardarNuevoCoach(@RequestBody CoachDTO coachDTO) throws Exception {
        CoachDTO coachResponse = coachService.guardarNuevoCoach(coachDTO);
        return new ResponseEntity<>(coachResponse, HttpStatus.CREATED);
    }

}


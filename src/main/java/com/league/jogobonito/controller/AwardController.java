package com.league.jogobonito.controller;

import com.league.jogobonito.dto.AwardDTO;
import com.league.jogobonito.repository.AwardRepository;
import com.league.jogobonito.service.AwardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/award")
public class AwardController {

    private AwardRepository awardRepository;
    private AwardService awardService;

    public AwardController(AwardRepository awardRepository, AwardService awardService) {
        this.awardRepository = awardRepository;
        this.awardService = awardService;
    }

    @PostMapping(value = "/guardarNuevoAward")
    public ResponseEntity<AwardDTO> guardarNuevoAward(@RequestBody AwardDTO awardDTO) throws Exception {
        AwardDTO awardResponse = awardService.guardarNuevoAward(awardDTO);
        return new ResponseEntity<>(awardResponse, HttpStatus.CREATED);
    }
}

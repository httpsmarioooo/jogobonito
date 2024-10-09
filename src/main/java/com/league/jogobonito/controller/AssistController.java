package com.league.jogobonito.controller;

import com.league.jogobonito.dto.AssistDTO;
import com.league.jogobonito.repository.AssistRepository;
import com.league.jogobonito.service.AssistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assists")
public class AssistController {

    private AssistRepository assistRepository;
    private AssistService assistService;

    public AssistController(AssistRepository assistRepository, AssistService assistService) {
        this.assistRepository = assistRepository;
        this.assistService = assistService;
    }

    @PostMapping(value = "/guardarNuevoAssists")
    public ResponseEntity<AssistDTO> guardarNuevoAssists(@RequestBody AssistDTO assistDTO) throws Exception {
        AssistDTO assistResponse = assistService.guardarNuevoAssists(assistDTO);
        return new ResponseEntity<>(assistResponse, HttpStatus.CREATED);
    }
}


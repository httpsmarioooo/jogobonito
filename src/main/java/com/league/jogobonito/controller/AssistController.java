package com.league.jogobonito.controller;


import com.league.jogobonito.domain.Assist;
import com.league.jogobonito.repository.AssistRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assists")
public class AssistController {

    private AssistRepository assistRepository;


    public AssistController(AssistRepository assistRepository) {
        this.assistRepository = assistRepository;
    }

    @GetMapping(value = "/obtenerAssists")
    public List<Assist> obtenerAssists() {
        return assistRepository.findAll();
    }
}


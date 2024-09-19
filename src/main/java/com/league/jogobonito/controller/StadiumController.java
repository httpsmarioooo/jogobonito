package com.league.jogobonito.controller;


import com.league.jogobonito.domain.Stadium;
import com.league.jogobonito.repository.StadiumRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stadium")
public class StadiumController {
    private StadiumRepository stadiumRepository;
    public StadiumController(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    @GetMapping(value = "/obtenerStadiums")
    public List<Stadium> obtenerStadiums() {
        return stadiumRepository.findAll();
    }
}






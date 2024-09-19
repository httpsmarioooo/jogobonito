package com.league.jogobonito.controller;
import com.league.jogobonito.domain.Match;
import com.league.jogobonito.repository.MatchRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {
    private MatchRepository matchRepository;
    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping(value = "/obtenerMatches")
    public List<Match> obtenerMatches() {
        return matchRepository.findAll();
    }
}

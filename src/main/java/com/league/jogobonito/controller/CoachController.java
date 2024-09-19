package com.league.jogobonito.controller;
import com.league.jogobonito.domain.Coach;
import com.league.jogobonito.repository.CoachRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {
    private CoachRepository coachRepository;
    public CoachController(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @RequestMapping(value = "/obtenerCoaches")
    public List<Coach> obtenerCoaches() {
        return coachRepository.findAll();
    }
}


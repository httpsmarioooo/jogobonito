package com.league.jogobonito.controller;
import com.league.jogobonito.domain.Goal;
import com.league.jogobonito.repository.GoalRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goal")
public class GoalController {
    private GoalRepository goalRepository;
    public GoalController(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @GetMapping(value = "/obtenerGoal")
    public List<Goal> obtenerGoal() {
        return goalRepository.findAll();
    }
}

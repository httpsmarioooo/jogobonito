package com.league.jogobonito.controller;

import com.league.jogobonito.dto.GoalDTO;
import com.league.jogobonito.repository.GoalRepository;
import com.league.jogobonito.service.GoalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goal")
public class GoalController {

    private GoalRepository goalRepository;
    private GoalService goalService;

    public GoalController(GoalRepository goalRepository, GoalService goalService) {
        this.goalRepository = goalRepository;
        this.goalService = goalService;
    }

    @PostMapping(value = "/guardarNuevoGoal")
    public ResponseEntity<GoalDTO> guardarNuevoGoal(@RequestBody GoalDTO goalDTO) throws Exception {
        GoalDTO goalResponse = goalService.guardarNuevoGoal(goalDTO);
        return new ResponseEntity<>(goalResponse, HttpStatus.CREATED);
    }

}

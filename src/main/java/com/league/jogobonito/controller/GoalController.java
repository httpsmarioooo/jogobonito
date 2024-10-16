package com.league.jogobonito.controller;

import com.league.jogobonito.domain.Goal;
import com.league.jogobonito.domain.Player;
import com.league.jogobonito.dto.GoalDTO;
import com.league.jogobonito.dto.PlayerDTO;
import com.league.jogobonito.mapper.GoalMapper;
import com.league.jogobonito.mapper.JudgeMapper;
import com.league.jogobonito.mapper.PlayerMapper;
import com.league.jogobonito.repository.GoalRepository;
import com.league.jogobonito.service.GoalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /*@GetMapping(value = "/obtenerGoal")
    public List<GoalDTO>obtenerGoal(){
        List<Goal>listaGoals = goalRepository.findAll();
        return GoalMapper.domainToDTOList(listaGoals);
    }

     */


}

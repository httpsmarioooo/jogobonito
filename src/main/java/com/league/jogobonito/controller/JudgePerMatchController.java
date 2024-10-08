package com.league.jogobonito.controller;

import com.league.jogobonito.dto.JudgePerMatchDTO;
import com.league.jogobonito.dto.JudgeRoleDTO;
import com.league.jogobonito.repository.JudgePerMatchRepository;
import com.league.jogobonito.service.JudgePerMatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/judge-per-match")
public class JudgePerMatchController {

    //Inyeccion de dependecias hacia CiudadServices
    private JudgePerMatchRepository judgePerMatchRepository;
    private JudgePerMatchService judgePerMatchService;

    public JudgePerMatchController(JudgePerMatchRepository judgePerMatchRepository, JudgePerMatchService judgePerMatchService) {
        this.judgePerMatchRepository = judgePerMatchRepository;
        this.judgePerMatchService = judgePerMatchService;
    }

    @PostMapping(value = "/guardarNuevoJudgePerMatch")
    public ResponseEntity<JudgePerMatchDTO> guardarNuevoJudgePerMatch(@RequestBody JudgePerMatchDTO judgePerMatchDTO) {
        JudgePerMatchDTO judgePerMatchResponse = judgePerMatchService.guardarNuevoJudgePerMatch(judgePerMatchDTO);
        return new ResponseEntity<>(judgePerMatchResponse, HttpStatus.CREATED);
    }
}

package com.league.jogobonito.controller;

import com.league.jogobonito.domain.JudgePerMatch;
import com.league.jogobonito.domain.MatchEvent;
import com.league.jogobonito.dto.JudgePerMatchDTO;
import com.league.jogobonito.dto.MatchEventDTO;
import com.league.jogobonito.mapper.JudgePerMatchMapper;
import com.league.jogobonito.mapper.MatchEventMapper;
import com.league.jogobonito.repository.JudgePerMatchRepository;
import com.league.jogobonito.service.JudgePerMatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public ResponseEntity<JudgePerMatchDTO> guardarNuevoJudgePerMatch(@RequestBody JudgePerMatchDTO judgePerMatchDTO) throws Exception {
        JudgePerMatchDTO judgePerMatchResponse = judgePerMatchService.guardarNuevoJudgePerMatch(judgePerMatchDTO);
        return new ResponseEntity<>(judgePerMatchResponse, HttpStatus.CREATED);
    }



    /*@GetMapping(value = "/obtenerJudgePerMatch")
    public List<JudgePerMatchDTO> obtenerJudgePerMatch(){
        List<JudgePerMatch>listaJudgePerMatch = judgePerMatchRepository.findAll();
        return JudgePerMatchMapper.domainToDTOList(listaJudgePerMatch);
    }

     */
}

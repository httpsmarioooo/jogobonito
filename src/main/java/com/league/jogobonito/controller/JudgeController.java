package com.league.jogobonito.controller;

import com.league.jogobonito.dto.JudgeDTO;
import com.league.jogobonito.service.JudgeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/judge")
public class JudgeController {
    private JudgeService judgeService;

    public JudgeController(JudgeService judgeService) {
        this.judgeService = judgeService;
    }

    @PostMapping(value = "/guardarNuevoJudge")
    public ResponseEntity<JudgeDTO> guardarNuevoJudge(@RequestBody JudgeDTO judgeDTO) throws Exception {
        JudgeDTO judgeResponse = judgeService.guardarNuevoJudge(judgeDTO);
        return new ResponseEntity<>(judgeResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerJudges")
    public List<JudgeDTO>obtenerJudges(){
        return judgeService.obtenerJudges();
    }

    @GetMapping("/buscarJudgePorId/{id}")
    public ResponseEntity<JudgeDTO> buscarJudgePorId (Integer id)throws Exception {
        JudgeDTO judgeResponse = judgeService.buscarJudgePorId(id);
        return new ResponseEntity<>(judgeResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarJudge")
    public ResponseEntity<JudgeDTO> modificarJudge(@RequestBody JudgeDTO judgeDTO) throws Exception {
        JudgeDTO judgeResponse = judgeService.modificarJudge(judgeDTO);
        return new ResponseEntity<>(judgeResponse, HttpStatus.CREATED);
    }



}



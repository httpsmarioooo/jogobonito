package com.league.jogobonito.controller;

import com.league.jogobonito.domain.Judge;
import com.league.jogobonito.dto.JudgeDTO;
import com.league.jogobonito.mapper.JudgeMapper;
import com.league.jogobonito.repository.JudgeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/judge")
public class JudgeController {
    private JudgeRepository judgeRepository;

    public JudgeController(JudgeRepository judgeRepository) {
        this.judgeRepository = judgeRepository;
    }


    @GetMapping(value = "/obtenerJudges")
    public List<JudgeDTO> obtenerJudges() {
        List<Judge>listaJudges = judgeRepository.findAll();
        List<JudgeDTO> judgesDTO = JudgeMapper.domainToDTOList(listaJudges);
        return judgesDTO;
    }

    @PostMapping(value = "/crearNuevoJudge")
    public ResponseEntity<JudgeDTO>crearNuevoJudge(@RequestBody JudgeDTO judgeDTO){
        JudgeDTO judgeDTOResponse = null;
        Judge judge = JudgeMapper.dtoToDomain(judgeDTO);
        judge = judgeRepository.save(judge);
        judgeDTOResponse = JudgeMapper.domainToDTO(judge);
        return new ResponseEntity<>(judgeDTOResponse, HttpStatus.CREATED);
    }
}



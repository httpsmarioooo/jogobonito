package com.league.jogobonito.controller;

import com.league.jogobonito.domain.Assist;
import com.league.jogobonito.domain.Goal;
import com.league.jogobonito.domain.JudgeRole;
import com.league.jogobonito.domain.Player;
import com.league.jogobonito.dto.AssistDTO;
import com.league.jogobonito.dto.GoalDTO;
import com.league.jogobonito.dto.JudgeRoleDTO;
import com.league.jogobonito.dto.PlayerDTO;
import com.league.jogobonito.mapper.AssistMapper;
import com.league.jogobonito.mapper.GoalMapper;
import com.league.jogobonito.mapper.JudgeRoleMapper;
import com.league.jogobonito.mapper.PlayerMapper;
import com.league.jogobonito.repository.AssistRepository;
import com.league.jogobonito.service.AssistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assists")
public class AssistController {

    private AssistRepository assistRepository;
    private AssistService assistService;

    public AssistController(AssistRepository assistRepository, AssistService assistService) {
        this.assistRepository = assistRepository;
        this.assistService = assistService;
    }

    @PostMapping(value = "/guardarNuevoAssists")
    public ResponseEntity<AssistDTO> guardarNuevoAssists(@RequestBody AssistDTO assistDTO) throws Exception {
        AssistDTO assistResponse = assistService.guardarNuevoAssists(assistDTO);
        return new ResponseEntity<>(assistResponse, HttpStatus.CREATED);
    }

    /*@GetMapping(value = "/obtenerAssists")
    public List<AssistDTO>obtenerAssists(){
        List<Assist>listaAssists = assistRepository.findAll();
        return AssistMapper.domainToDTOList(listaAssists);
    }

     */


}


package com.league.jogobonito.controller;

import com.league.jogobonito.domain.Coach;
import com.league.jogobonito.domain.Player;
import com.league.jogobonito.dto.CoachDTO;
import com.league.jogobonito.dto.PlayerDTO;
import com.league.jogobonito.mapper.CoachMapper;
import com.league.jogobonito.mapper.PlayerMapper;
import com.league.jogobonito.repository.CoachRepository;
import com.league.jogobonito.service.CoachService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/coach")
public class CoachController {

    private CoachRepository coachRepository;
    private CoachService coachService;

    public CoachController(CoachRepository coachRepository, CoachService coachService) {
        this.coachRepository = coachRepository;
        this.coachService = coachService;
    }

    @PostMapping(value = "/guardarNuevoCoach")
    public ResponseEntity<CoachDTO> guardarNuevoCoach(@RequestBody CoachDTO coachDTO) throws Exception {
        CoachDTO coachResponse = coachService.guardarNuevoCoach(coachDTO);
        return new ResponseEntity<>(coachResponse, HttpStatus.CREATED);
    }

    /////////

    @GetMapping(value = "/obtenerCoach")
    public List<CoachDTO> obtenerCoach(){
        List<Coach>listaCoaches = coachRepository.findAll();
        return CoachMapper.domainToDTOList(listaCoaches);
    }

    @GetMapping("/buscarCoachPorId/{id}")
    public ResponseEntity<CoachDTO> buscarCoachPorId (Integer id)throws Exception {
        CoachDTO coachResponse = coachService.buscarCoachPorId(id);
        return new ResponseEntity<>(coachResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarCoach")
    public ResponseEntity<CoachDTO> modificarCoach(@RequestBody CoachDTO coachDTO) throws Exception {
        CoachDTO coachResponse = coachService.modificarCoach(coachDTO);
        return new ResponseEntity<>(coachResponse, HttpStatus.OK);
    }

}


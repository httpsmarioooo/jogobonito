package com.league.jogobonito.controller;

import com.league.jogobonito.dto.AwardDTO;
import com.league.jogobonito.repository.AwardRepository;
import com.league.jogobonito.service.AwardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/award")
public class AwardController {


    private AwardService awardService;

    public AwardController(AwardService awardService) {
        this.awardService = awardService;
    }

    @PostMapping(value = "/guardarNuevoAward")
    public ResponseEntity<AwardDTO> guardarNuevoAward(@RequestBody AwardDTO awardDTO) throws Exception {
        AwardDTO awardResponse = awardService.guardarNuevoAward(awardDTO);
        return new ResponseEntity<>(awardResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerAwards")
    public List<AwardDTO>obtenerAwards(){
        return awardService.obtenerAwards();
    }


    @GetMapping("/buscarAwardPorId/{id}")
    public ResponseEntity<AwardDTO> buscarAwardPorId (Integer id)throws Exception {
        AwardDTO awardResponse = awardService.buscarAwardPorId(id);
        return new ResponseEntity<>(awardResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarAward")
    public ResponseEntity<AwardDTO> modificarAward(@RequestBody AwardDTO awardDTO) throws Exception {
        AwardDTO awardResponse = awardService.modificarAward(awardDTO);
        return new ResponseEntity<>(awardResponse, HttpStatus.OK);
    }


}

package com.league.jogobonito.controller;

import com.league.jogobonito.domain.Award;
import com.league.jogobonito.domain.Player;
import com.league.jogobonito.dto.AwardDTO;
import com.league.jogobonito.dto.PlayerDTO;
import com.league.jogobonito.mapper.AwardMapper;
import com.league.jogobonito.mapper.PlayerMapper;
import com.league.jogobonito.repository.AwardRepository;
import com.league.jogobonito.service.AwardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/award")
public class AwardController {

    private AwardRepository awardRepository;
    private AwardService awardService;

    public AwardController(AwardRepository awardRepository, AwardService awardService) {
        this.awardRepository = awardRepository;
        this.awardService = awardService;
    }

    @PostMapping(value = "/guardarNuevoAward")
    public ResponseEntity<AwardDTO> guardarNuevoAward(@RequestBody AwardDTO awardDTO) throws Exception {
        AwardDTO awardResponse = awardService.guardarNuevoAward(awardDTO);
        return new ResponseEntity<>(awardResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerAward")
    public List<AwardDTO>obtenerAward(){
        List<Award>listaAwards = awardRepository.findAll();
        return AwardMapper.domainToDTOList(listaAwards);
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

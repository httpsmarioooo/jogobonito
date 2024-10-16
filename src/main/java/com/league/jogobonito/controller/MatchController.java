package com.league.jogobonito.controller;

import com.league.jogobonito.domain.Match;
import com.league.jogobonito.domain.Player;
import com.league.jogobonito.dto.MatchDTO;
import com.league.jogobonito.dto.PlayerDTO;
import com.league.jogobonito.mapper.MatchMapper;
import com.league.jogobonito.mapper.PlayerMapper;
import com.league.jogobonito.repository.MatchRepository;
import com.league.jogobonito.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    private MatchRepository matchRepository;
    private MatchService matchService;

    public MatchController(MatchRepository matchRepository, MatchService matchService) {
        this.matchRepository = matchRepository;
        this.matchService = matchService;
    }
    @PostMapping(value = "/guardarNuevoMatch")
    public ResponseEntity<MatchDTO> guardarNuevoMatch(@RequestBody MatchDTO matchDTO) throws Exception {
        MatchDTO matchResponse = matchService.guardarNuevoMatch(matchDTO);
        return new ResponseEntity<>(matchResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerMatch")
    public List<MatchDTO> obtenerMatch(){
        List<Match>listaMatches = matchRepository.findAll();
        return MatchMapper.domainToDTOList(listaMatches);
    }

    @GetMapping("/buscarMatchPorId/{id}")
    public ResponseEntity<MatchDTO> buscarMatchPorId (Integer id)throws Exception {
        MatchDTO matchResponse = matchService.buscarMatchPorId(id);
        return new ResponseEntity<>(matchResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarMatch")
    public ResponseEntity<MatchDTO> modificarMatch(@RequestBody MatchDTO matchDTO) throws Exception {
        MatchDTO matchResponse = matchService.modificarMatch(matchDTO);
        return new ResponseEntity<>(matchResponse, HttpStatus.OK);
    }
}

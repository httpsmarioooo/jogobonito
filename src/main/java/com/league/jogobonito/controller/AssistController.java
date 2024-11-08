package com.league.jogobonito.controller;

import com.league.jogobonito.dto.AssistDTO;
import com.league.jogobonito.service.AssistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assists")
public class AssistController {

    private AssistService assistService;

    public AssistController(AssistService assistService) {
        this.assistService = assistService;
    }

    @PostMapping(value = "/guardarNuevoAssists")
    public ResponseEntity<AssistDTO> guardarNuevoAssists(@RequestBody AssistDTO assistDTO) throws Exception {
        AssistDTO assistResponse = assistService.guardarNuevoAssists(assistDTO);
        return new ResponseEntity<>(assistResponse, HttpStatus.CREATED);
    }

    @GetMapping("/buscarAssistPorId/{id}")
    public ResponseEntity<AssistDTO> buscarAssistPorId (Integer id)throws Exception {
        AssistDTO assistResponse = assistService.buscarAssistPorId(id);
        return new ResponseEntity<>(assistResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/obtenerAssists")
    public List<AssistDTO>obtenerAssists(){
        return assistService.obtenerAssists();
    }

    @PutMapping(value = "/modificarAssist")
    public ResponseEntity<AssistDTO> modificarAssist(@RequestBody AssistDTO assistDTO) throws Exception {
        AssistDTO assistResponse = assistService.modificarAssist(assistDTO);
        return new ResponseEntity<>(assistResponse, HttpStatus.CREATED);
    }

    /*@GetMapping(value = "/obtenerAssists")
    public List<AssistDTO>obtenerAssists(){
        List<Assist>listaAssists = assistRepository.findAll();
        return AssistMapper.domainToDTOList(listaAssists);
    }

     */

}


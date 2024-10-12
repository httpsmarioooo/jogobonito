package com.league.jogobonito.controller;

import com.league.jogobonito.dto.MatchEventDTO;
import com.league.jogobonito.repository.MatchEventRepository;
import com.league.jogobonito.service.MatchEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match-event")
public class MatchEventController {

    private MatchEventRepository matchEventRepository;
    private MatchEventService matchEventService;

    public MatchEventController(MatchEventRepository matchEventRepository, MatchEventService matchEventService) {
        this.matchEventRepository = matchEventRepository;
        this.matchEventService = matchEventService;
    }

    @PostMapping(value = "/guardarNuevoMatchEvent")
    public ResponseEntity<MatchEventDTO> guardarNuevoMatchEvent(@RequestBody MatchEventDTO matchEventDTO) throws Exception {
        MatchEventDTO matchEventResponse = matchEventService.guardarNuevoMatchEvent(matchEventDTO);
        return new ResponseEntity<>(matchEventResponse, HttpStatus.CREATED);
    }


}

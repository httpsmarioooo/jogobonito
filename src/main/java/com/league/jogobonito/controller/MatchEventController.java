package com.league.jogobonito.controller;
import com.league.jogobonito.domain.MatchEvent;
import com.league.jogobonito.repository.MatchEventRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/match-event")
public class MatchEventController {
    private MatchEventRepository matchEventRepository;
    public MatchEventController(MatchEventRepository matchEventRepository) {
        this.matchEventRepository = matchEventRepository;
    }

    @GetMapping(value = "/obtenerMatchEvent")
    public List<MatchEvent> obtenerMatchEvent() {
        return matchEventRepository.findAll();

    }
}

package com.league.jogobonito.controller;
import com.league.jogobonito.domain.Standing;
import com.league.jogobonito.repository.StandingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/standing")
public class StandingController {
    private StandingRepository standingRepository;
    public StandingController(StandingRepository standingRepository) {
        this.standingRepository = standingRepository;
    }

    @GetMapping(value = "/obtenerStandings")
    public List<Standing> obtenerStandings() {
        return standingRepository.findAll();
    }
}

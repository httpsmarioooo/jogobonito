package com.league.jogobonito.controller;
import com.league.jogobonito.domain.Award;
import com.league.jogobonito.repository.AwardRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/award")
public class AwardController {
    private AwardRepository awardRepository;
    public AwardController(AwardRepository awardRepository) {
        this.awardRepository = awardRepository;
    }

    @GetMapping(value = "/obtenerAwards")
    public List<Award> obtenerStadiums() {
        return awardRepository.findAll();
    }
}

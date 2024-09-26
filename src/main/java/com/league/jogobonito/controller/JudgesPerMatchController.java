package com.league.jogobonito.controller;
import com.league.jogobonito.domain.JudgeRole;
import com.league.jogobonito.domain.JudgesPerMatch;
import com.league.jogobonito.repository.JudgeRoleRepository;
import com.league.jogobonito.repository.JudgesPerMatchRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/judge-per-match")
public class JudgesPerMatchController {
    private JudgesPerMatchRepository judgesPerMatchRepository;
    public JudgesPerMatchController(JudgesPerMatchRepository judgesPerMatchRepository) {
        this.judgesPerMatchRepository = judgesPerMatchRepository;
    }

    @GetMapping(value = "/obtenerJudgePerMatch")
    public List<JudgesPerMatch> obtenerJudgePerMatch() {
        return judgesPerMatchRepository.findAll();
    }

}

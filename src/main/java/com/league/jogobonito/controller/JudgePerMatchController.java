package com.league.jogobonito.controller;
import com.league.jogobonito.domain.JudgePerMatch;
import com.league.jogobonito.repository.JudgePerMatchRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/judge-per-match")
public class JudgePerMatchController {
    private JudgePerMatchRepository judgePerMatchRepository;
    public JudgePerMatchController(JudgePerMatchRepository judgePerMatchRepository) {
        this.judgePerMatchRepository = judgePerMatchRepository;
    }

    @GetMapping(value = "/obtenerJudgesPerMatch")
    public List<JudgePerMatch> obtenerJudgePerMatch() {
        return judgePerMatchRepository.findAll();
    }

}

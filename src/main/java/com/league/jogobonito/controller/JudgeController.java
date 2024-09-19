package com.league.jogobonito.controller;
import com.league.jogobonito.domain.Judge;
import com.league.jogobonito.repository.JudgeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping ("/judge")
public class JudgeController {
    private JudgeRepository judgeRepository;
    public JudgeController(JudgeRepository judgeRepository) {
        this.judgeRepository = judgeRepository;
    }

    @GetMapping(value = "/obtenerJudges")
    public List<Judge> obtenerJudges() {
        return judgeRepository.findAll();
    }
}



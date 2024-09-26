package com.league.jogobonito.controller;
import com.league.jogobonito.domain.JudgeRole;
import com.league.jogobonito.repository.JudgeRoleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/judge-role")
public class JudgeRoleController {
    private JudgeRoleRepository judgeRoleRepository;
    public JudgeRoleController(JudgeRoleRepository judgeRoleRepository) {
        this.judgeRoleRepository = judgeRoleRepository;
    }

    @GetMapping(value = "/obtenerJudgeRole")
    public List<JudgeRole> obtenerJudgeRole() {
        return judgeRoleRepository.findAll();
    }

}


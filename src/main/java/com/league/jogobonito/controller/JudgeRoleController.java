package com.league.jogobonito.controller;

import com.league.jogobonito.domain.JudgeRole;
import com.league.jogobonito.dto.JudgeRoleDTO;
import com.league.jogobonito.mapper.JudgeRoleMapper;
import com.league.jogobonito.repository.JudgeRoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/judge-role")
public class JudgeRoleController {
    private JudgeRoleRepository judgeRoleRepository;

    public JudgeRoleController(JudgeRoleRepository judgeRoleRepository) {
        this.judgeRoleRepository = judgeRoleRepository;
    }

    @GetMapping(value = "/obtenerJudgeRole")
    public List<JudgeRoleDTO> obtenerJudgeRole() {

        List<JudgeRole>listaJudgeRoles = judgeRoleRepository.findAll();
        List<JudgeRoleDTO> judgeRolesDTO = JudgeRoleMapper.domainToDTOList(listaJudgeRoles);

        return judgeRolesDTO;
    }

    @PostMapping(value = "/cearNuevoJudgeRole")
    public ResponseEntity<JudgeRoleDTO> cearNuevoJudgeRole (@RequestBody JudgeRoleDTO judgeRoleDTO) {
        JudgeRoleDTO judgeRoleDTOResponse = null;

        JudgeRole judgeRole = JudgeRoleMapper.dtoToDomain(judgeRoleDTO);
        judgeRole = judgeRoleRepository.save(judgeRole);

        judgeRoleDTOResponse = JudgeRoleMapper.domainToDT0(judgeRole);
        return new ResponseEntity<>(judgeRoleDTOResponse, HttpStatus.CREATED);
    }

}


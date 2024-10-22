package com.league.jogobonito.controller;

import com.league.jogobonito.dto.JudgeRoleDTO;
import com.league.jogobonito.service.JudgeRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/judge-role")
public class JudgeRoleController {
    private JudgeRoleService judgeRoleService;

    public JudgeRoleController(JudgeRoleService judgeRoleService) {
        this.judgeRoleService = judgeRoleService;
    }

    @PostMapping(value = "/guardarNuevoJudgeRole")
    public ResponseEntity<JudgeRoleDTO> guardarNuevoJudgeRole(@RequestBody JudgeRoleDTO judgeRoleDTO) throws Exception {
        JudgeRoleDTO judgeRoleResponse = judgeRoleService.guardarNuevoJudgeRole(judgeRoleDTO);
        return new ResponseEntity<>(judgeRoleResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerJudgeRole")
    public List<JudgeRoleDTO>obtenerJudgeRole(){
        return judgeRoleService.obtenerJudgeRole();
    }

    @GetMapping("/buscarJudgeRolePorId/{id}")
    public ResponseEntity<JudgeRoleDTO> buscarJudgeRolePorId (Integer id)throws Exception {
        JudgeRoleDTO judgeRoleResponse = judgeRoleService.buscarJudgeRolePorId(id);
        return new ResponseEntity<>(judgeRoleResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarJudgeRole")
    public ResponseEntity<JudgeRoleDTO> modificarJudgeRole(@RequestBody JudgeRoleDTO judgeRoleDTO) throws Exception {
        JudgeRoleDTO judgeRoleResponse = judgeRoleService.modificarJudgeRole(judgeRoleDTO);
        return new ResponseEntity<>(judgeRoleResponse, HttpStatus.CREATED);
    }

}


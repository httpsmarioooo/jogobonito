package com.league.jogobonito.service;

import com.league.jogobonito.dto.JudgeRoleDTO;
import java.util.List;

public interface JudgeRoleService {
    JudgeRoleDTO guardarNuevoJudgeRole(JudgeRoleDTO judgeRoleDTO) throws Exception;
    JudgeRoleDTO buscarJudgeRolePorId(Integer id) throws Exception;
    JudgeRoleDTO modificarJudgeRole(JudgeRoleDTO judgeRoleDTO) throws Exception;
    List<JudgeRoleDTO> obtenerJudgeRole();
}

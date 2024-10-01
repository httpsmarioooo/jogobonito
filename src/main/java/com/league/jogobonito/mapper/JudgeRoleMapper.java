package com.league.jogobonito.mapper;

import com.league.jogobonito.domain.JudgeRole;
import com.league.jogobonito.dto.JudgeRoleDTO;

import java.util.List;

public class JudgeRoleMapper {

    public static JudgeRole dtoToDomain(JudgeRoleDTO judgeRoleDTO){
        JudgeRole judgeRole = new JudgeRole();
        judgeRole.setId(judgeRoleDTO.getId());
        judgeRole.setRoleName(judgeRoleDTO.getRoleName());

        return judgeRole;
    }

    public static JudgeRoleDTO domainToDT0(JudgeRole judgeRole){
        return JudgeRoleDTO.builder().
                id(judgeRole.getId()).
                roleName(judgeRole.getRoleName()).
                build();
    }

    public static List<JudgeRole>dtoToDomainList(List<JudgeRoleDTO>judgeRoleDTO){
        return judgeRoleDTO.stream().map(JudgeRoleMapper::dtoToDomain).toList();
    }

        public static List<JudgeRoleDTO> domainToDTOList(List<JudgeRole> judgeRoles){
        return judgeRoles.stream().map(JudgeRoleMapper::domainToDT0).toList();
        }
}

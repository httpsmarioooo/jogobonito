package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.JudgeRole;
import com.league.jogobonito.dto.JudgeRoleDTO;
import com.league.jogobonito.mapper.JudgeRoleMapper;
import com.league.jogobonito.repository.JudgeRoleRepository;
import com.league.jogobonito.service.JudgeRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JudgeRoleServiceImpl implements JudgeRoleService {
    private final JudgeRoleRepository judgeRoleRepository;

    public JudgeRoleServiceImpl(JudgeRoleRepository judgeRoleRepository) {
        this.judgeRoleRepository = judgeRoleRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JudgeRoleDTO guardarNuevoJudgeRole(JudgeRoleDTO judgeRoleDTO) throws Exception {

        if(judgeRoleDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (judgeRoleDTO.getRoleName() == null || judgeRoleDTO.getRoleName().isBlank()) {
            throw new Exception("El nombre del rol no debe ser nulo o vacío");
        }

        JudgeRole judgeRole = JudgeRoleMapper.dtoToDomain(judgeRoleDTO);
        judgeRole = judgeRoleRepository.save(judgeRole);
        return JudgeRoleMapper.domainToDto(judgeRole);
    }


    @Override
    @Transactional(readOnly = true)
    public JudgeRoleDTO buscarJudgeRolePorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        JudgeRole judgeRole = judgeRoleRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el judge role con el id " +id));
        return JudgeRoleMapper.domainToDto(judgeRole);
    }



    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JudgeRoleDTO modificarJudgeRole(JudgeRoleDTO judgeRoleDTO) throws Exception {
        if(judgeRoleDTO.getId() == null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (judgeRoleDTO.getRoleName() == null || judgeRoleDTO.getRoleName().isBlank()) {
            throw new Exception("El nombre del rol no debe ser nulo o vacío");
        }

        JudgeRole judgeRole = JudgeRoleMapper.dtoToDomain(judgeRoleDTO);
        judgeRole = judgeRoleRepository.save(judgeRole);
        return JudgeRoleMapper.domainToDto(judgeRole);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JudgeRoleDTO> obtenerJudgeRole() {
        List<JudgeRole>listaJudgeRoles = judgeRoleRepository.findAll();
        List<JudgeRoleDTO>judgeRoleDTO = JudgeRoleMapper.domainToDTOList(listaJudgeRoles);
        return JudgeRoleMapper.domainToDTOList(listaJudgeRoles);
    }
}

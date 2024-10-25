package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.*;
import com.league.jogobonito.dto.JudgePerMatchDTO;
import com.league.jogobonito.mapper.JudgePerMatchMapper;
import com.league.jogobonito.repository.*;
import com.league.jogobonito.service.JudgePerMatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudgePerMatchServiceImpl implements JudgePerMatchService {

    private final JudgePerMatchRepository judgePerMatchRepository;

    private final MatchRepository matchRepository;
    private final JudgeRepository judgeRepository;
    private final JudgeRoleRepository judgeRoleRepository;

    public JudgePerMatchServiceImpl(JudgePerMatchRepository judgePerMatchRepository, MatchRepository matchRepository, JudgeRepository judgeRepository,JudgeRoleRepository judgeRoleRepository) {
        this.judgePerMatchRepository = judgePerMatchRepository;
        this.matchRepository = matchRepository;
        this.judgeRepository = judgeRepository;
        this.judgeRoleRepository = judgeRoleRepository;
    }

    @Override
    public JudgePerMatchDTO guardarNuevoJudgePerMatch(JudgePerMatchDTO judgePerMatchDTO) throws Exception {

        //1. Validacion id debe de ser null

        if(judgePerMatchDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        //2. Validaciones dependencias, llaves etc

        if(judgePerMatchDTO.getMatchId() == null) {
            throw new Exception("El MatchId no debe ser nulo");
        }

        if(judgePerMatchDTO.getJudgeId() == null) {
            throw new Exception("El JudgeId no debe ser nulo");
        }

        if(judgePerMatchDTO.getRoleId() == null) {
            throw new Exception("El RoleId no debe ser nulo");
        }

        //Ultimas validaciones en el mismo impl en la parte final---
        JudgePerMatch judgePerMatch = JudgePerMatchMapper.dtoToDomain(judgePerMatchDTO);

        Match match = matchRepository.getReferenceById(judgePerMatchDTO.getMatchId());
        Judge judge = judgeRepository.getReferenceById(judgePerMatchDTO.getJudgeId());
        JudgeRole judgeRole = judgeRoleRepository.getReferenceById(judgePerMatchDTO.getRoleId());

        if (match == null){
            throw new Exception("El Match no existe");
        }


        if (judge == null){
            throw new Exception("El Judge no existe");
        }


        if (judgeRole == null){
            throw new Exception("El JudgeRole no existe");
        }

        judgePerMatch.setMatch(match);
        judgePerMatch.setJudge(judge);
        judgePerMatch.setJudgeRole(judgeRole);

        judgePerMatch = judgePerMatchRepository.save(judgePerMatch);

        return JudgePerMatchMapper.domainToDto(judgePerMatch);
    }

    @Override
    public JudgePerMatchDTO buscarJudgePerMatchPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        JudgePerMatch judgePerMatch = judgePerMatchRepository.getReferenceById(id);
        if (judgePerMatch == null) {
            throw new Exception("No se encuentra el player con el id"+id);
        }

        JudgePerMatchDTO judgePerMatchDTO = JudgePerMatchMapper.domainToDto(judgePerMatch);
        return judgePerMatchDTO;
    }

    @Override
    public List<JudgePerMatchDTO> obtenerJudgesPerMatch() {
        List<JudgePerMatch>listaJudgesPerMatch = judgePerMatchRepository.findAll();
        List<JudgePerMatchDTO>judgesPerMatchDTO = JudgePerMatchMapper.domainToDTOList(listaJudgesPerMatch);
        return JudgePerMatchMapper.domainToDTOList(listaJudgesPerMatch);
    }
}

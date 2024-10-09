package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.JudgePerMatch;
import com.league.jogobonito.domain.Judge;
import com.league.jogobonito.domain.JudgeRole;
import com.league.jogobonito.domain.Match;
import com.league.jogobonito.dto.JudgePerMatchDTO;
import com.league.jogobonito.mapper.JudgePerMatchMapper;
import com.league.jogobonito.repository.*;
import com.league.jogobonito.service.JudgePerMatchService;
import org.springframework.stereotype.Service;

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
}

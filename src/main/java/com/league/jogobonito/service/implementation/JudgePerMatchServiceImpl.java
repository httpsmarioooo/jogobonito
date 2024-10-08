package com.league.jogobonito.service.implementation;


import com.league.jogobonito.dto.JudgePerMatchDTO;
import com.league.jogobonito.service.JudgePerMatchService;
import org.springframework.stereotype.Service;

@Service
public class JudgePerMatchServiceImpl implements JudgePerMatchService {
    @Override
    public JudgePerMatchDTO guardarNuevoJudgePerMatch(JudgePerMatchDTO judgePerMatchDTO) throws Exception {

        //1. Validacion id debe de ser null

        if(judgePerMatchDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }


        //2. Validaciones dependencias, llaves etc

        if(judgePerMatchDTO.getMatchId() != null) {
            throw new Exception("El MatchId no debe ser nulo");
        }

        if(judgePerMatchDTO.getJudgeId() != null) {
            throw new Exception("El JudgeId no debe ser nulo");
        }

        if(judgePerMatchDTO.getRoleId() != null) {
            throw new Exception("El RoleId no debe ser nulo");
        }






        return null;
    }
}

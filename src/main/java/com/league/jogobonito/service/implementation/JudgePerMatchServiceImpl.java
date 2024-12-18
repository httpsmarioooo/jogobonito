package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.*;
import com.league.jogobonito.dto.JudgePerMatchDTO;
import com.league.jogobonito.mapper.JudgePerMatchMapper;
import com.league.jogobonito.repository.*;
import com.league.jogobonito.service.JudgePerMatchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
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

//        Match match = matchRepository.getReferenceById(judgePerMatchDTO.getMatchId());
//        Judge judge = judgeRepository.getReferenceById(judgePerMatchDTO.getJudgeId());
//        JudgeRole judgeRole = judgeRoleRepository.getReferenceById(judgePerMatchDTO.getRoleId());
//
//        if (match == null){
//            throw new Exception("El Match no existe");
//        }
//
//
//        if (judge == null){
//            throw new Exception("El Judge no existe");
//        }
//
//
//        if (judgeRole == null){
//            throw new Exception("El JudgeRole no existe");
//        }
//
//        judgePerMatch.setMatch(match);
//        judgePerMatch.setJudge(judge);
//        judgePerMatch.setJudgeRole(judgeRole);

        Match match = matchRepository.findById(judgePerMatchDTO.getMatchId())
                .orElseThrow(() -> new Exception("El Match no existe"));
        judgePerMatch.setMatch(match);

        Judge judge = judgeRepository.findById(judgePerMatchDTO.getJudgeId())
                .orElseThrow(() -> new Exception("El Judge no existe"));
        judgePerMatch.setJudge(judge);

        JudgeRole judgeRole = judgeRoleRepository.findById(judgePerMatchDTO.getRoleId())
                .orElseThrow(() -> new Exception("El Judge no existe"));
        judgePerMatch.setJudgeRole(judgeRole);

        judgePerMatch = judgePerMatchRepository.save(judgePerMatch);
        return JudgePerMatchMapper.domainToDto(judgePerMatch);
    }

    @Override
    @Transactional(readOnly = true)
    public JudgePerMatchDTO buscarJudgePerMatchPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        JudgePerMatch judgePerMatch = judgePerMatchRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el JudgePerMatch con el id " +id));
        return JudgePerMatchMapper.domainToDto(judgePerMatch);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JudgePerMatchDTO modificarJudgePerMatch(JudgePerMatchDTO judgePerMatchDTO) throws Exception {
        if(judgePerMatchDTO.getId() == null) {
            throw new Exception("El id no debe de ser nulo");
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

//        Match match = matchRepository.getReferenceById(judgePerMatchDTO.getMatchId());
//        Judge judge = judgeRepository.getReferenceById(judgePerMatchDTO.getJudgeId());
//        JudgeRole judgeRole = judgeRoleRepository.getReferenceById(judgePerMatchDTO.getRoleId());
//
//        if (match == null){
//            throw new Exception("El Match no existe");
//        }
//
//
//        if (judge == null){
//            throw new Exception("El Judge no existe");
//        }
//
//
//        if (judgeRole == null){
//            throw new Exception("El JudgeRole no existe");
//        }
//
//        judgePerMatch.setMatch(match);
//        judgePerMatch.setJudge(judge);
//        judgePerMatch.setJudgeRole(judgeRole);

        Match match = matchRepository.findById(judgePerMatchDTO.getMatchId())
                .orElseThrow(() -> new Exception("El Match no existe"));
        judgePerMatch.setMatch(match);

        Judge judge = judgeRepository.findById(judgePerMatchDTO.getJudgeId())
                .orElseThrow(() -> new Exception("El Judge no existe"));
        judgePerMatch.setJudge(judge);

        JudgeRole judgeRole = judgeRoleRepository.findById(judgePerMatchDTO.getRoleId())
                .orElseThrow(() -> new Exception("El Judge no existe"));
        judgePerMatch.setJudgeRole(judgeRole);

        judgePerMatch = judgePerMatchRepository.save(judgePerMatch);
        return JudgePerMatchMapper.domainToDto(judgePerMatch);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JudgePerMatchDTO> obtenerJudgesPerMatch() {
        List<JudgePerMatch>listaJudgesPerMatch = judgePerMatchRepository.findAll();
        List<JudgePerMatchDTO>judgesPerMatchDTO = JudgePerMatchMapper.domainToDTOList(listaJudgesPerMatch);
        return JudgePerMatchMapper.domainToDTOList(listaJudgesPerMatch);
    }
}

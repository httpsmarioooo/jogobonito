package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.Judge;
import com.league.jogobonito.dto.JudgeDTO;
import com.league.jogobonito.mapper.JudgeMapper;
import com.league.jogobonito.repository.JudgeRepository;
import com.league.jogobonito.service.JudgeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JudgeServiceImpl implements JudgeService {
    private final JudgeRepository judgeRepository;

    public JudgeServiceImpl(JudgeRepository judgeRepository) {
        this.judgeRepository = judgeRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JudgeDTO guardarNuevoJudge(JudgeDTO judgeDTO) throws Exception {

        if(judgeDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (judgeDTO.getName() == null || judgeDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (judgeDTO.getCountryOfBirth() == null || judgeDTO.getCountryOfBirth().isBlank()) {
            throw new Exception("El nombre del pais en donde nació no debe ser nula o vacía");
        }

        Judge judge = JudgeMapper.dtoToDomain(judgeDTO);
        judge = judgeRepository.save(judge);
        return JudgeMapper.domainToDto(judge);
    }



    @Override
    @Transactional(readOnly = true)
    public JudgeDTO buscarJudgePorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        Judge judge = judgeRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el judgde con el id" +id));
        return JudgeMapper.domainToDto(judge);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JudgeDTO modificarJudge(JudgeDTO judgeDTO) throws Exception {
        if(judgeDTO.getId() == null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (judgeDTO.getName() == null || judgeDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (judgeDTO.getCountryOfBirth() == null || judgeDTO.getCountryOfBirth().isBlank()) {
            throw new Exception("El nombre del pais en donde nació no debe ser nula o vacía");
        }

        Judge judge = JudgeMapper.dtoToDomain(judgeDTO);
        judge = judgeRepository.save(judge);
        return JudgeMapper.domainToDto(judge);

    }

    @Override
    @Transactional(readOnly = true)
    public List<JudgeDTO> obtenerJudges() {
        List<Judge>listaJudges = judgeRepository.findAll();
        List<JudgeDTO>judgesDTO = JudgeMapper.domainToDTOList(listaJudges);
        return JudgeMapper.domainToDTOList(listaJudges);
    }
}

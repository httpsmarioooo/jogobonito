package com.league.jogobonito.service;

import com.league.jogobonito.dto.JudgePerMatchDTO;
import java.util.List;

public interface JudgePerMatchService {
    JudgePerMatchDTO guardarNuevoJudgePerMatch(JudgePerMatchDTO judgePerMatchDTO) throws Exception;
    JudgePerMatchDTO buscarJudgePerMatchPorId(Integer id) throws Exception;
    JudgePerMatchDTO modificarJudgePerMatch(JudgePerMatchDTO judgePerMatchDTO) throws Exception;
    List<JudgePerMatchDTO> obtenerJudgesPerMatch();
}

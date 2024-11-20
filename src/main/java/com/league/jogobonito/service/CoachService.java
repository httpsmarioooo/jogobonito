package com.league.jogobonito.service;

import com.league.jogobonito.dto.CoachDTO;
import java.util.List;

public interface CoachService {
    CoachDTO guardarNuevoCoach(CoachDTO coachDTO) throws Exception;
    CoachDTO buscarCoachPorId(Integer id) throws Exception;
    CoachDTO modificarCoach(CoachDTO coachDTO) throws Exception;
    List<CoachDTO> obtenerCoaches();
}

package com.league.jogobonito.service;

import com.league.jogobonito.dto.CoachDTO;

import java.util.List;

public interface CoachService {
    CoachDTO guardarNuevoCoach(CoachDTO coachDTO) throws Exception;
    CoachDTO buscarCoachPorId(Integer Id) throws Exception;
    CoachDTO modificarCoach(CoachDTO coachDTO) throws Exception;
    List<CoachDTO> obtenerCoaches();
}

package com.league.jogobonito.service;

import com.league.jogobonito.dto.GoalDTO;

import java.util.List;

public interface GoalService {
    GoalDTO guardarNuevoGoal(GoalDTO goalDTO) throws Exception;
    GoalDTO buscarGoalPorId(Integer id) throws Exception;
    List<GoalDTO> obtenerGoals();
}

package com.league.jogobonito.service;

import com.league.jogobonito.dto.GoalDTO;

public interface GoalService {
    GoalDTO guardarNuevoGoal(GoalDTO goalDTO) throws Exception;
}

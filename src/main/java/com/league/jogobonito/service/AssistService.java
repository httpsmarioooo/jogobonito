package com.league.jogobonito.service;

import com.league.jogobonito.domain.Assist;
import com.league.jogobonito.dto.AssistDTO;

import java.util.List;

public interface AssistService {
    AssistDTO guardarNuevoAssists(AssistDTO assistDTO) throws Exception;
}

package com.league.jogobonito.service;

import com.league.jogobonito.dto.AssistDTO;
import java.util.List;

public interface AssistService {
    AssistDTO guardarNuevoAssists(AssistDTO assistDTO) throws Exception;
    AssistDTO buscarAssistPorId(Integer id) throws Exception;
    AssistDTO modificarAssist(AssistDTO assistDTO) throws Exception;
    List<AssistDTO> obtenerAssists();

}

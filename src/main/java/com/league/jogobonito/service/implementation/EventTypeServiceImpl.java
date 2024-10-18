package com.league.jogobonito.service.implementation;

import com.league.jogobonito.dto.EventTypeDTO;
import com.league.jogobonito.service.EventTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTypeServiceImpl implements EventTypeService {

    @Override
    public EventTypeDTO guardarNuevoEventType(EventTypeDTO eventTypeDTO) throws Exception {
        return null;
    }

    @Override
    public EventTypeDTO buscarEventTypePorId(Integer id) throws Exception {
        return null;
    }

    @Override
    public EventTypeDTO modificarEventType(EventTypeDTO eventTypeDTO) throws Exception {
        return null;
    }

    @Override
    public List<EventTypeDTO> obtenerEventType() {
        return List.of();
    }
}

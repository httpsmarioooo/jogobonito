package com.league.jogobonito.controller;

import com.league.jogobonito.domain.EventType;
import com.league.jogobonito.dto.EventTypeDTO;
import com.league.jogobonito.mapper.EventTypeMapper;
import com.league.jogobonito.repository.EventTypeRepository;
import jdk.jfr.Event;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/event-type")
public class EventTypeController {
    private EventTypeRepository eventTypeRepository;

    public EventTypeController(EventTypeRepository eventTypeRepository) {
        this.eventTypeRepository = eventTypeRepository;
    }

    @GetMapping(value = "/obtenerEventType")
    public List<EventTypeDTO> obtenerEventType() {
        List<EventType>listaEventTypes = eventTypeRepository.findAll();
        List<EventTypeDTO> eventTypesDTO = EventTypeMapper.domainToDTOList(listaEventTypes);

        return eventTypesDTO;
    }

    @PostMapping(value = "/crearEventType")
    public ResponseEntity<EventTypeDTO>crearEventType(@RequestBody EventTypeDTO eventTypeDTO) {
        EventTypeDTO eventTypeDTOResponse = null;

        EventType eventType = EventTypeMapper.dtoToDomain(eventTypeDTO);
        eventType = eventTypeRepository.save(eventType);

        eventTypeDTOResponse = EventTypeMapper.domainToDTO(eventType);
        return new ResponseEntity<>(eventTypeDTOResponse, HttpStatus.CREATED);
    }

}

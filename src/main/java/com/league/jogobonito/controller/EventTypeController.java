package com.league.jogobonito.controller;

import com.league.jogobonito.dto.EventTypeDTO;
import com.league.jogobonito.service.EventTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event-type")
public class EventTypeController {
    private EventTypeService eventTypeService;

    public EventTypeController(EventTypeService eventTypeService) {
        this.eventTypeService = eventTypeService;
    }

    @PostMapping(value = "/guardarNuevoEventType")
    public ResponseEntity<EventTypeDTO> guardarNuevoEventType(@RequestBody EventTypeDTO eventTypeDTO) throws Exception {
        EventTypeDTO eventTypeResponse = eventTypeService.guardarNuevoEventType(eventTypeDTO);
        return new ResponseEntity<>(eventTypeResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerEventType")
    public List<EventTypeDTO>obtenerEventType(){
        return eventTypeService.obtenerEventType();
    }

    @GetMapping("/buscarEventTypePorId/{id}")
    public ResponseEntity<EventTypeDTO> buscarEventTypePorId (Integer id)throws Exception {
        EventTypeDTO eventTypeResponse = eventTypeService.buscarEventTypePorId(id);
        return new ResponseEntity<>(eventTypeResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarEventType")
    public ResponseEntity<EventTypeDTO> modificarEventType(@RequestBody EventTypeDTO eventTypeDTO) throws Exception {
        EventTypeDTO eventTypeResponse = eventTypeService.modificarEventType(eventTypeDTO);
        return new ResponseEntity<>(eventTypeResponse, HttpStatus.CREATED);
    }

}

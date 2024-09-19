package com.league.jogobonito.controller;
import com.league.jogobonito.domain.EventType;
import com.league.jogobonito.repository.EventTypeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/event-type")
public class EventTypeController {
    private EventTypeRepository eventTypeRepository;
    public EventTypeController(EventTypeRepository eventTypeRepository) {
        this.eventTypeRepository = eventTypeRepository;
    }

    @GetMapping(value = "/obtenerEventType")
    public List<EventType> obtenerEventType() {
        return eventTypeRepository.findAll();
    }

}

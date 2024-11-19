package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.EventType;
import com.league.jogobonito.dto.EventTypeDTO;
import com.league.jogobonito.mapper.EventTypeMapper;
import com.league.jogobonito.repository.EventTypeRepository;
import com.league.jogobonito.service.EventTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventTypeServiceImpl implements EventTypeService {

    private final EventTypeRepository eventTypeRepository;

    public EventTypeServiceImpl(EventTypeRepository eventTypeRepository) {
        this.eventTypeRepository = eventTypeRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public EventTypeDTO guardarNuevoEventType(EventTypeDTO eventTypeDTO) throws Exception {

        if(eventTypeDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (eventTypeDTO.getName() == null || eventTypeDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        EventType eventType = EventTypeMapper.dtoToDomain(eventTypeDTO);
        eventType = eventTypeRepository.save(eventType);
        return EventTypeMapper.domainToDto(eventType);
    }

    @Override
    @Transactional(readOnly = true)
    public EventTypeDTO buscarEventTypePorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        EventType eventType = eventTypeRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el event type con el id " +id));
        return EventTypeMapper.domainToDto(eventType);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public EventTypeDTO modificarEventType(EventTypeDTO eventTypeDTO) throws Exception {
        if(eventTypeDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (eventTypeDTO.getName() == null || eventTypeDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        EventType eventType = EventTypeMapper.dtoToDomain(eventTypeDTO);
        eventType = eventTypeRepository.save(eventType);
        return EventTypeMapper.domainToDto(eventType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EventTypeDTO> obtenerEventType() {
        List<EventType>listaEventTypes = eventTypeRepository.findAll();
        List<EventTypeDTO>eventTypeDTO = EventTypeMapper.domainToDTOList(listaEventTypes);
        return EventTypeMapper.domainToDTOList(listaEventTypes);
    }
}

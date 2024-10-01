package com.league.jogobonito.mapper;

import com.league.jogobonito.domain.EventType;
import com.league.jogobonito.dto.EventTypeDTO;

import java.util.List;

public class EventTypeMapper {
    public static EventType dtoToDomain(EventTypeDTO eventTypeDTO){
        EventType eventType = new EventType();
        eventType.setId(eventTypeDTO.getId());
        eventType.setName(eventTypeDTO.getName());

        return eventType;
    }

    public static EventTypeDTO domainToDTO(EventType eventType) {
        return EventTypeDTO.builder().
                id(eventType.getId()).
                name(eventType.getName()).
                build();
    }

    public static List<EventType> dtoToDomainList(List<EventTypeDTO> eventTypesDTO) {
        return eventTypesDTO.stream().map(EventTypeMapper::dtoToDomain).toList();
    }

    public static List<EventTypeDTO> domainToDTOList(List<EventType> eventTypes) {
        return eventTypes.stream().map(EventTypeMapper::domainToDTO).toList();
    }



}



/*
Para trabajar con la tabla event_type, puedes seguir el mismo patrón que has usado con stadiums,
solo adaptando los nombres. Aunque el nombre de la tabla es en singular (event_type), en el
código vamos a referirnos a la lista en plural como eventTypes para que sea coherente con el mapeo.


 Puedes seguir utilizando el nombre en singular (event_type)
 en tu base de datos y manejar el plural solo en el código Java,
 específicamente cuando trabajas con listas de objetos.

 */

package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.*;
import com.league.jogobonito.dto.MatchEventDTO;
import com.league.jogobonito.mapper.MatchEventMapper;
import com.league.jogobonito.repository.EventTypeRepository;
import com.league.jogobonito.repository.MatchEventRepository;
import com.league.jogobonito.repository.MatchRepository;
import com.league.jogobonito.repository.PlayerRepository;
import com.league.jogobonito.service.MatchEventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MatchEventServiceImpl implements MatchEventService{

    private final MatchEventRepository matchEventRepository;

    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;
    private final EventTypeRepository eventTypeRepository;

    public MatchEventServiceImpl(MatchEventRepository matchEventRepository, MatchRepository matchRepository, PlayerRepository playerRepository, EventTypeRepository eventTypeRepository) {
        this.matchEventRepository = matchEventRepository;
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
        this.eventTypeRepository = eventTypeRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public MatchEventDTO guardarNuevoMatchEvent(MatchEventDTO matchEventDTO) throws Exception {
        if(matchEventDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if(matchEventDTO .getMinute() == null) {
            throw new Exception("El minuto no debe de ser nulo");
        }

        if (matchEventDTO.getDescription() == null || matchEventDTO.getDescription().isBlank()) {
            throw new Exception("la descripcion no debe ser nulo o vacío");
        }

        if(matchEventDTO.getMatchId() == null) {
            throw new Exception("El Matchid debe no debe de ser nulo");
        }


        if(matchEventDTO.getPlayerId() == null) {
            throw new Exception("El Playerid no debe de ser nulo");
        }

        if(matchEventDTO.getEventTypeId() == null) {
            throw new Exception("El EventType no debe de ser nulo");
        }

        MatchEvent matchEvent = MatchEventMapper.dtoToDomain(matchEventDTO);

        Match match = matchRepository.getReferenceById(matchEventDTO.getMatchId());
        Player player = playerRepository.getReferenceById(matchEventDTO.getPlayerId());
        EventType eventType = eventTypeRepository.getReferenceById(matchEventDTO.getEventTypeId());

        if (match == null){
            throw new Exception("El Match no existe");
        }

        if (player == null){
            throw new Exception("El Player no existe");
        }

        if (eventType == null){
            throw new Exception("El EventType no existe");
        }

        matchEvent.setMatch(match);
        matchEvent.setPlayer(player);
        matchEvent.setEventType(eventType);
        matchEvent = matchEventRepository.save(matchEvent);

        return MatchEventMapper.domainToDto(matchEvent);
    }

    @Override
    @Transactional(readOnly = true)
    public MatchEventDTO buscarMatchEventPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        MatchEvent matchEvent = matchEventRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el MatchEvent con el id " +id));
        return MatchEventMapper.domainToDto(matchEvent);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public MatchEventDTO modificarMatchEvent(MatchEventDTO matchEventDTO) throws Exception {
        if(matchEventDTO.getId() == null) {
            throw new Exception("El id no debe de ser nulo");
        }

        if(matchEventDTO .getMinute() == null) {
            throw new Exception("El minuto no debe de ser nulo");
        }

        if (matchEventDTO.getDescription() == null || matchEventDTO.getDescription().isBlank()) {
            throw new Exception("la descripcion no debe ser nulo o vacío");
        }

        if(matchEventDTO.getMatchId() == null) {
            throw new Exception("El Matchid debe no debe de ser nulo");
        }


        if(matchEventDTO.getPlayerId() == null) {
            throw new Exception("El Playerid no debe de ser nulo");
        }

        if(matchEventDTO.getEventTypeId() == null) {
            throw new Exception("El EventType no debe de ser nulo");
        }

        MatchEvent matchEvent = MatchEventMapper.dtoToDomain(matchEventDTO);

        Match match = matchRepository.getReferenceById(matchEventDTO.getMatchId());
        Player player = playerRepository.getReferenceById(matchEventDTO.getPlayerId());
        EventType eventType = eventTypeRepository.getReferenceById(matchEventDTO.getEventTypeId());

        if (match == null){
            throw new Exception("El Match no existe");
        }

        if (player == null){
            throw new Exception("El Player no existe");
        }

        if (eventType == null){
            throw new Exception("El EventType no existe");
        }

        matchEvent.setMatch(match);
        matchEvent.setPlayer(player);
        matchEvent.setEventType(eventType);
        matchEvent = matchEventRepository.save(matchEvent);

        return MatchEventMapper.domainToDto(matchEvent);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MatchEventDTO> obtenerMatchEvents() {
        List<MatchEvent>listaMatchEvents = matchEventRepository.findAll();
        List<MatchEventDTO>matchEventsDTO = MatchEventMapper.domainToDTOList(listaMatchEvents);
        return MatchEventMapper.domainToDTOList(listaMatchEvents);
    }

}

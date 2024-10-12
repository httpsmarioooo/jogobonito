package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.EventType;
import com.league.jogobonito.domain.Match;
import com.league.jogobonito.domain.MatchEvent;
import com.league.jogobonito.domain.Player;
import com.league.jogobonito.dto.MatchEventDTO;
import com.league.jogobonito.mapper.MatchEventMapper;
import com.league.jogobonito.repository.EventTypeRepository;
import com.league.jogobonito.repository.MatchEventRepository;
import com.league.jogobonito.repository.MatchRepository;
import com.league.jogobonito.repository.PlayerRepository;
import com.league.jogobonito.service.MatchEventService;
import org.springframework.stereotype.Service;

@Service
public class matchEventServiceImpl implements MatchEventService{

    private final MatchEventRepository matchEventRepository;

    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;
    private final EventTypeRepository eventTypeRepository;

    public matchEventServiceImpl(MatchEventRepository matchEventRepository, MatchRepository matchRepository, PlayerRepository playerRepository, EventTypeRepository eventTypeRepository) {
        this.matchEventRepository = matchEventRepository;
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
        this.eventTypeRepository = eventTypeRepository;
    }

    @Override
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
}

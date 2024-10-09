package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.Assist;
import com.league.jogobonito.domain.Match;
import com.league.jogobonito.domain.Player;
import com.league.jogobonito.dto.AssistDTO;
import com.league.jogobonito.mapper.AssistMapper;
import com.league.jogobonito.repository.AssistRepository;
import com.league.jogobonito.repository.MatchRepository;
import com.league.jogobonito.repository.PlayerRepository;
import com.league.jogobonito.service.AssistService;
import org.springframework.stereotype.Service;

@Service
public class AssistServiceImpl implements AssistService {

    private final AssistRepository assistRepository;

    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;

    public AssistServiceImpl(AssistRepository assistRepository, MatchRepository matchRepository, PlayerRepository playerRepository) {
        this.assistRepository = assistRepository;
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public AssistDTO guardarNuevoAssists(AssistDTO assistDTO) throws Exception {

        if(assistDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if(assistDTO.getMinute() == null) {
            throw new Exception("El minuto no debe de ser nulo");
        }

        if(assistDTO.getMatchId() == null) {
            throw new Exception("El Matchid debe no debe de ser nulo");
        }

        if(assistDTO.getPlayerId() == null) {
            throw new Exception("El Playerid no debe de ser nulo");
        }

        Assist assist = AssistMapper.dtoToDomain(assistDTO);
        Player player = playerRepository.getReferenceById(assistDTO.getPlayerId());
        Match match = matchRepository.getReferenceById(assistDTO.getMatchId());

        if (player == null){
            throw new Exception("El Player no existe");
        }

        if (match == null){
            throw new Exception("El Player no existe");
        }

        assist.setPlayer(player);
        assist.setMatch(match);
        assist = assistRepository.save(assist);
        return AssistMapper.domainToDto(assist);

    }
}

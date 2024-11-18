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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public AssistDTO guardarNuevoAssists(AssistDTO assistDTO) throws Exception {

        if(assistDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if(assistDTO.getMinute() == null) {
            throw new Exception("El minuto no debe de ser nulo");
        }

        if(assistDTO.getMatchId() == null) {
            throw new Exception("El MatchId debe no debe de ser nulo");
        }

        if(assistDTO.getPlayerId() == null) {
            throw new Exception("El PlayerId no debe de ser nulo");
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

    @Override
    @Transactional(readOnly = true)
    public AssistDTO buscarAssistPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }


        Assist assist = assistRepository.getReferenceById(id);
        if (assist == null) {
            throw new Exception("No se encuentra la asistencia con el id"+id);
        }

        AssistDTO assistDTO = AssistMapper.domainToDto(assist);
        return assistDTO;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public AssistDTO modificarAssist(AssistDTO assistDTO) throws Exception {
        if(assistDTO.getId() == null) {
            throw new Exception("El id no puede ser nulo");
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

    @Override
    @Transactional(readOnly = true)
    public List<AssistDTO> obtenerAssists() {
        List<Assist>listaAssits = assistRepository.findAll();
        List<AssistDTO>assitsDTO = AssistMapper.domainToDTOList(listaAssits);
        return AssistMapper.domainToDTOList(listaAssits);
    }
}

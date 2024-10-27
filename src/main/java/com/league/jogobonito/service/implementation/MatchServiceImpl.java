package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.Match;
import com.league.jogobonito.domain.Stadium;
import com.league.jogobonito.domain.Team;
import com.league.jogobonito.dto.MatchDTO;
import com.league.jogobonito.mapper.MatchMapper;
import com.league.jogobonito.repository.MatchRepository;
import com.league.jogobonito.repository.StadiumRepository;
import com.league.jogobonito.repository.TeamRepository;
import com.league.jogobonito.service.MatchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;

    private final StadiumRepository stadiumRepository;
    private final TeamRepository teamRepository;

    public MatchServiceImpl(MatchRepository matchRepository, StadiumRepository stadiumRepository, TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.stadiumRepository = stadiumRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public MatchDTO guardarNuevoMatch(MatchDTO matchDTO) throws Exception {

        if(matchDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        // Validar la fecha después de validar el ID
        if (matchDTO.getDate() == null) {
            throw new Exception("La fecha no puede ser nula");
        }

        // Validar que la fecha no esté en el pasado
        Date today = new Date(); // Fecha actual
        if (matchDTO.getDate().before(today)) {
            throw new Exception("La fecha no puede estar en el pasado");
        }

        if (matchDTO.getHomeTeamScore() == null) {
            throw new Exception("La HomeTeamScore no puede ser nula");
        }

        if (matchDTO.getAwayTeamScore() == null) {
            throw new Exception("La AwayTeamScore no puede ser nula");
        }

        if(matchDTO.getStadiumId() == null) {
            throw new Exception("El StadiumId no debe de ser nulo");
        }

        if(matchDTO.getTeamId() == null) {
            throw new Exception("El TeamId no debe de ser nulo");
        }

        if(matchDTO.getTeamId2() == null) {
            throw new Exception("El TeamId2 no debe de ser nulo");
        }

        Match match = MatchMapper.dtoToDomain(matchDTO);
        Team team = teamRepository.getReferenceById(matchDTO.getTeamId());
        Stadium stadium  = stadiumRepository.getReferenceById(matchDTO.getStadiumId());

        if (team == null){
            throw new Exception("El Team no existe");
        }

        if (stadium == null){
            throw new Exception("El stadium no existe");
        }

        match.setTeam(team);
        match.setStadium(stadium);

        match = matchRepository.save(match);
        return MatchMapper.domainToDto(match);
    }

    @Override
    @Transactional(readOnly = true)
    public MatchDTO buscarMatchPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        Match match = matchRepository.getReferenceById(id);
        if (match == null) {
            throw new Exception("No se encuentra el match con el id"+id);
        }

        MatchDTO matchDTO = MatchMapper.domainToDto(match);
        return matchDTO;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public MatchDTO modificarMatch(MatchDTO matchDTO) throws Exception {

        if(matchDTO.getId() == null) {
            throw new Exception("El id no puede ser nulo");
        }

        // Validar la fecha después de validar el ID
        if (matchDTO.getDate() == null) {
            throw new Exception("La fecha no puede ser nula");
        }

        // Validar que la fecha no esté en el pasado
        Date today = new Date(); // Fecha actual
        if (matchDTO.getDate().before(today)) {
            throw new Exception("La fecha no puede estar en el pasado");
        }

        if (matchDTO.getHomeTeamScore() == null) {
            throw new Exception("La HomeTeamScore no puede ser nula");
        }

        if (matchDTO.getAwayTeamScore() == null) {
            throw new Exception("La AwayTeamScore no puede ser nula");
        }

        if(matchDTO.getStadiumId() == null) {
            throw new Exception("El StadiumId no debe de ser nulo");
        }

        if(matchDTO.getTeamId() == null) {
            throw new Exception("El TeamId no debe de ser nulo");
        }

        if(matchDTO.getTeamId2() == null) {
            throw new Exception("El TeamId2 no debe de ser nulo");
        }

        Match match = MatchMapper.dtoToDomain(matchDTO);
        Team team = teamRepository.getReferenceById(matchDTO.getTeamId());
        Stadium stadium  = stadiumRepository.getReferenceById(matchDTO.getStadiumId());

        if (team == null){
            throw new Exception("El Team no existe");
        }

        if (stadium == null){
            throw new Exception("El stadium no existe");
        }

        match.setTeam(team);
        match.setStadium(stadium);
        match = matchRepository.save(match);

        return MatchMapper.domainToDto(match);

    }

}

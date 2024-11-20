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
import java.util.List;


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
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
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

        if(matchDTO.getHomeTeamId() == null) {
            throw new Exception("El HomeTeamId  no debe de ser nulo");
        }

        if(matchDTO.getAwayTeamId() == null) {
            throw new Exception("El AwayTeamId  no debe de ser nulo");
        }

        // Validar que los equipos local y visitante no sean los mismos
        if (matchDTO.getHomeTeamId().equals(matchDTO.getAwayTeamId())) {
            throw new Exception("No se puede crear un partido con el mismo equipo como local y visitante");
        }

        Match match = MatchMapper.dtoToDomain(matchDTO);

//        Team homeTeam = teamRepository.getReferenceById(matchDTO.getHomeTeamId());
//        Team awayTeam = teamRepository.getReferenceById(matchDTO.getAwayTeamId());
//        Stadium stadium  = stadiumRepository.getReferenceById(matchDTO.getStadiumId());
//
//        if (homeTeam == null) {
//            throw new Exception("El Home Team no existe");
//        }
//        if (awayTeam == null) { // Agrega esta validación
//            throw new Exception("El Away Team no existe");
//        }
//        if (stadium == null) {
//            throw new Exception("El Stadium no existe");
//        }
//
//        match.setTeam(homeTeam);
//        match.setTeam2(awayTeam); // Asigna el equipo visitante
//        match.setStadium(stadium);


        Team homeTeam = teamRepository.findById(matchDTO.getHomeTeamId())
                .orElseThrow(() -> new Exception("El HomeTeam no existe"));
        match.setTeam(homeTeam);

        Team awayTeam = teamRepository.findById(matchDTO.getAwayTeamId())
                .orElseThrow(() -> new Exception("El AwayTeam no existe"));
        match.setTeam2(awayTeam);

        Stadium stadium = stadiumRepository.findById(matchDTO.getStadiumId())
                .orElseThrow(() -> new Exception("El Stadium no existe"));
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

        Match match = matchRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el Match  con el id" +id));
        return MatchMapper.domainToDto(match);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public MatchDTO modificarMatch(MatchDTO matchDTO) throws Exception {
        if(matchDTO.getId() == null) {
            throw new Exception("El id no debe de ser nulo");
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

        if(matchDTO.getHomeTeamId() == null) {
            throw new Exception("El HomeTeamId  no debe de ser nulo");
        }

        if(matchDTO.getAwayTeamId() == null) {
            throw new Exception("El AwayTeamId  no debe de ser nulo");
        }

        // Validar que los equipos local y visitante no sean los mismos
        if (matchDTO.getHomeTeamId().equals(matchDTO.getAwayTeamId())) {
            throw new Exception("No se puede crear un partido con el mismo equipo como local y visitante");
        }

        Match match = MatchMapper.dtoToDomain(matchDTO);

//        Team homeTeam = teamRepository.getReferenceById(matchDTO.getHomeTeamId());
//        Team awayTeam = teamRepository.getReferenceById(matchDTO.getAwayTeamId());
//        Stadium stadium  = stadiumRepository.getReferenceById(matchDTO.getStadiumId());
//
//        if (homeTeam == null) {
//            throw new Exception("El Home Team no existe");
//        }
//        if (awayTeam == null) { // Agrega esta validación
//            throw new Exception("El Away Team no existe");
//        }
//        if (stadium == null) {
//            throw new Exception("El Stadium no existe");
//        }
//
//        match.setTeam(homeTeam);
//        match.setTeam2(awayTeam); // Asigna el equipo visitante
//        match.setStadium(stadium);


        Team homeTeam = teamRepository.findById(matchDTO.getHomeTeamId())
                .orElseThrow(() -> new Exception("El HomeTeam no existe"));
        match.setTeam(homeTeam);

        Team awayTeam = teamRepository.findById(matchDTO.getAwayTeamId())
                .orElseThrow(() -> new Exception("El AwayTeam no existe"));
        match.setTeam2(awayTeam);

        Stadium stadium = stadiumRepository.findById(matchDTO.getStadiumId())
                .orElseThrow(() -> new Exception("El Stadium no existe"));
        match.setStadium(stadium);

        match = matchRepository.save(match);
        return MatchMapper.domainToDto(match);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MatchDTO> obtenerMatches() {
        List<Match>listaMatches = matchRepository.findAll();
        List<MatchDTO>matchesDTO = MatchMapper.domainToDTOList(listaMatches);
        return MatchMapper.domainToDTOList(listaMatches);
    }

}

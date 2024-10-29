package com.league.jogobonito.service.implementation;


import com.league.jogobonito.domain.Goal;
import com.league.jogobonito.domain.Match;
import com.league.jogobonito.domain.Player;
import com.league.jogobonito.dto.GoalDTO;
import com.league.jogobonito.mapper.GoalMapper;
import com.league.jogobonito.repository.GoalRepository;
import com.league.jogobonito.repository.MatchRepository;
import com.league.jogobonito.repository.PlayerRepository;
import com.league.jogobonito.service.GoalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;

    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;


    public GoalServiceImpl(GoalRepository goalRepository, MatchRepository matchRepository, PlayerRepository playerRepository) {
        this.goalRepository = goalRepository;
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public GoalDTO guardarNuevoGoal(GoalDTO goalDTO) throws Exception {

        if(goalDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if(goalDTO.getMinute() == null) {
            throw new Exception("El minuto no debe de ser nulo");
        }

        if(goalDTO.getMatchId() == null) {
            throw new Exception("El Matchid debe no debe de ser nulo");
        }

        if(goalDTO.getPlayerId() == null) {
            throw new Exception("El Playerid no debe de ser nulo");
        }

        Goal goal = GoalMapper.dtoToDomain(goalDTO);
        Player player = playerRepository.getReferenceById(goalDTO.getPlayerId());
        Match match = matchRepository.getReferenceById(goalDTO.getMatchId());

        if (player == null){
            throw new Exception("El Player no existe");
        }

        if (match == null){
            throw new Exception("El Match no existe");
        }

        goal.setPlayer(player);
        goal.setMatch(match);
        goal = goalRepository.save(goal);
        return GoalMapper.domainToDto(goal);
    }

    @Override
    @Transactional(readOnly = true)

    public GoalDTO buscarGoalPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }


        Goal goal = goalRepository.getReferenceById(id);
        if (goal == null) {
            throw new Exception("No se encuentra el goal con el id "+id);
        }

        GoalDTO goalDTO = GoalMapper.domainToDto(goal);
        return goalDTO;
    }

    @Override
    public GoalDTO modificarGoal(GoalDTO goalDTO) throws Exception {
        if(goalDTO.getId() == null) {
            throw new Exception("El id no debe de ser nulo");
        }

        if(goalDTO.getMinute() == null) {
            throw new Exception("El minuto no debe de ser nulo");
        }

        if(goalDTO.getMatchId() == null) {
            throw new Exception("El Matchid debe no debe de ser nulo");
        }

        if(goalDTO.getPlayerId() == null) {
            throw new Exception("El Playerid no debe de ser nulo");
        }

        Goal goal = GoalMapper.dtoToDomain(goalDTO);
        Player player = playerRepository.getReferenceById(goalDTO.getPlayerId());
        Match match = matchRepository.getReferenceById(goalDTO.getMatchId());

        if (player == null){
            throw new Exception("El Player no existe");
        }

        if (match == null){
            throw new Exception("El Match no existe");
        }

        goal.setPlayer(player);
        goal.setMatch(match);
        goal = goalRepository.save(goal);
        return GoalMapper.domainToDto(goal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GoalDTO> obtenerGoals() {
        List<Goal>listaGoals = goalRepository.findAll();
        List<GoalDTO>goalsDTO = GoalMapper.domainToDTOList(listaGoals);
        return GoalMapper.domainToDTOList(listaGoals);
    }

}

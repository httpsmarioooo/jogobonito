package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.*;
import com.league.jogobonito.dto.PlayerDTO;
import com.league.jogobonito.mapper.PlayerMapper;
import com.league.jogobonito.repository.*;
import com.league.jogobonito.service.PlayerService;
import org.springframework.stereotype.Service;
import java.util.Date;


@Service
public class PlayerServiceImpl implements PlayerService  {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public PlayerDTO guardarNuevoPlayer(PlayerDTO playerDTO) throws Exception {

        //1. Validacion id debe de ser null

        if(playerDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        //2. Validaciones dependencias, llaves etc

        if (playerDTO.getName() == null || playerDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (playerDTO.getPosition() == null || playerDTO.getPosition().isBlank()) {
            throw new Exception("La posición no debe ser nula o vacía");
        }

        if (playerDTO.getJerseyNumber() == null || playerDTO.getJerseyNumber().isBlank()) {
            throw new Exception("El número del jersey no debe ser nulo o vacío");
        }

        if (playerDTO.getBirthDate() == null || playerDTO.getBirthDate().after(new Date())) {
            throw new Exception("La fecha de nacimiento no debe ser nula ni futura");
        }

        if (playerDTO.getHeightCm() == null || playerDTO.getHeightCm() <= 0) {
            throw new Exception("La altura en cm debe ser mayor a 0");
        }

        if (playerDTO.getCountryOfBirth() == null || playerDTO.getCountryOfBirth().isBlank()) {
            throw new Exception("El país de nacimiento no debe ser nulo o vacío");
        }

        if(playerDTO.getTeamId() == null) {
            throw new Exception("El TeamId no debe ser nulo");
        }

        //Ultimas validaciones en el mismo impl en la parte final---
        Player player = PlayerMapper.dtoToDomain(playerDTO);
        Team team = teamRepository.getReferenceById(playerDTO.getTeamId());

        if (team == null){
            throw new Exception("El Team no existe");
        }

        player.setTeam(team);
        player = playerRepository.save(player);
        return PlayerMapper.domainToDto(player);
    }
}
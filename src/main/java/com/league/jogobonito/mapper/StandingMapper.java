package com.league.jogobonito.mapper;

import com.league.jogobonito.domain.Standing;
import com.league.jogobonito.dto.StandingDTO;

import java.util.List;

public class StandingMapper {

    public static Standing dtoToDomain (StandingDTO standingDTO){
        return Standing.builder()

                //agregar el id????????
                .points(standingDTO.getPoints())
                .goalsFor(standingDTO.getGoalsFor())
                .goalsAgainst(standingDTO.getGoalsAgainst())
                .build();
    }

    public static StandingDTO domainToDto (Standing standing){
        return StandingDTO.builder()
                .teamId((standing.getTeam() != null) ? standing.getTeam().getId() : null)
                .points(standing.getPoints())
                .goalsFor(standing.getGoalsFor())
                .goalsAgainst(standing.getGoalsAgainst())
                .build();
    }

    public static List<Standing> dtoToDomainList(List<StandingDTO>standingDTO){
        return standingDTO.stream().map(StandingMapper::dtoToDomain).toList();
    }

    public static List<StandingDTO> domainToDTOList(List<Standing> standings){
        return standings.stream().map(StandingMapper::domainToDto).toList();
    }

}

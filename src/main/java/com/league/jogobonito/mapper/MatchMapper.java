package com.league.jogobonito.mapper;

import com.league.jogobonito.domain.Match;
import com.league.jogobonito.dto.MatchDTO;

import java.util.List;


public class MatchMapper {
    public static Match dtoToDomain (MatchDTO matchDTO){
        return Match.builder()
                .id(matchDTO.getId())
                //PREGUNTA SOBRE EL DATE
                .date(matchDTO.getDate())
                .homeTeamScore(matchDTO.getHomeTeamScore())
                .awayTeamScore(matchDTO.getAwayTeamScore())
                .build();
    }

    public static MatchDTO domainToDto(Match match){
        return MatchDTO.builder()
                .id(match.getId())
                //PREGUNTA SOBRE EL DATA
                .date(match.getDate())
                .homeTeamScore(match.getHomeTeamScore())
                .awayTeamScore(match.getAwayTeamScore())
                .stadiumId((match.getStadium().getId() != null) ? match.getStadium().getId() : null)
                .homeTeamId(match.getTeam() != null ? match.getTeam().getId() : null)
                .awayTeamId(match.getTeam2() != null ? match.getTeam2(). getId() : null)
                .build();
    }

    public static List<Match> dtoToDomainList(List<MatchDTO>matchDTO){
        return matchDTO.stream().map(MatchMapper::dtoToDomain).toList();
    }

    public static List<MatchDTO> domainToDTOList(List<Match> matches){
        return matches.stream().map(MatchMapper::domainToDto).toList();
    }
}

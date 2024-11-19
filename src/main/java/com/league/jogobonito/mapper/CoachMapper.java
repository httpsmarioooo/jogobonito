package com.league.jogobonito.mapper;

import com.league.jogobonito.domain.Coach;
import com.league.jogobonito.dto.CoachDTO;
import java.util.List;

public class CoachMapper {

    public static Coach dtoToDomain (CoachDTO coachDTO){
        return Coach.builder()
                .id(coachDTO.getId())
                .name(coachDTO.getName())
                .build();
    }

    public static CoachDTO domainToDto(Coach coach){
        return CoachDTO.builder()
                .id(coach.getId())
                .name(coach.getName())
                .teamId(coach.getTeam() != null ? coach.getTeam().getId() : null)
                .build();
    }

    public static List<Coach> dtoToDomainList(List<CoachDTO>coachDTO){
        return coachDTO.stream().map(CoachMapper::dtoToDomain).toList();
    }

    public static List<CoachDTO> domainToDTOList(List<Coach> coaches){
        return coaches.stream().map(CoachMapper::domainToDto).toList();
    }
}


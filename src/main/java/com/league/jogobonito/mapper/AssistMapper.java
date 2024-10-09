package com.league.jogobonito.mapper;

import com.league.jogobonito.domain.Assist;
import com.league.jogobonito.dto.AssistDTO;

import java.util.List;

public class AssistMapper {

    public static Assist dtoToDomain (AssistDTO assistDTO){
        return Assist.builder()
                .id(assistDTO.getId())
                .minute(assistDTO.getMinute())
                .build();
    }

    public static AssistDTO domainToDto (Assist assist){
        return AssistDTO.builder()
                .id(assist.getId())
                .minute(assist.getMinute())
                .playerId((assist.getPlayer() != null) ? assist.getPlayer().getId() : null)
                .matchId((assist.getMatch() != null) ? assist.getMatch().getId() : null)
                .build();
    }

    public static List<Assist> dtoToDomainList(List<AssistDTO>assistDTO){
        return assistDTO.stream().map(AssistMapper::dtoToDomain).toList();
    }

    public static List<AssistDTO> domainToDTOList(List<Assist> assists){
        return assists.stream().map(AssistMapper::domainToDto).toList();
    }


}

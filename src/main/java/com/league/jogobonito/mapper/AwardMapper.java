package com.league.jogobonito.mapper;

import com.league.jogobonito.domain.Award;
import com.league.jogobonito.dto.AwardDTO;
import java.util.List;

public class AwardMapper {
    public static Award dtoToDomain (AwardDTO awardDTO){
        return Award.builder()
                .id(awardDTO.getId())
                .name(awardDTO.getName())
                .description(awardDTO.getDescription())
                .build();
    }

    public static AwardDTO domainToDto (Award award){
        return AwardDTO.builder()
                .id(award.getId())
                .name(award.getName())
                .description(award.getDescription())
                .playerId((award.getPlayer() != null) ? award.getPlayer().getId() : null)
                .build();
    }

    public static List<Award> dtoToDomainList(List<AwardDTO>awardDTO){
        return awardDTO.stream().map(AwardMapper::dtoToDomain).toList();
    }

    public static List<AwardDTO> domainToDTOList(List<Award> awards){
        return awards.stream().map(AwardMapper::domainToDto).toList();
    }
}

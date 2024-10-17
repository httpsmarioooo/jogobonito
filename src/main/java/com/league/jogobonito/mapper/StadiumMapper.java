package com.league.jogobonito.mapper;

import com.league.jogobonito.domain.Stadium;
import com.league.jogobonito.dto.StadiumDTO;
import java.util.List;

public class StadiumMapper {
    public static Stadium dtoToDomain(StadiumDTO stadiumDTO) {
        Stadium stadium = new Stadium();
        stadium.setId(stadiumDTO.getId());
        stadium.setName(stadiumDTO.getName());
        stadium.setCity(stadiumDTO.getCity());
        stadium.setCapacity(stadiumDTO.getCapacity());
        stadium.setCountry(stadiumDTO.getCountry());
        return stadium;
    }

    public static StadiumDTO domainToDto(Stadium stadium) {
        return StadiumDTO.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .city(stadium.getCity())
                .capacity(stadium.getCapacity())
                .country(stadium.getCountry())
                .build();
    }

    public static List<Stadium>dtoToDomainList(List<StadiumDTO>StadiumsDTO){
        return StadiumsDTO.stream().map(StadiumMapper::dtoToDomain).toList();
    }

    public static List<StadiumDTO> domainToDTOList(List<Stadium>stadiums){
        return stadiums.stream().map(StadiumMapper::domainToDto).toList();
    }
}

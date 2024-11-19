package com.league.jogobonito.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AwardDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer playerId;
}

package com.league.jogobonito.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StandingDTO {
    private Integer teamId;
    private Integer points;
    private Integer goalsFor;
    private Integer goalsAgainst;
}

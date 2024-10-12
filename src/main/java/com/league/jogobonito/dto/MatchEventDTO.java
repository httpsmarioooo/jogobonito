package com.league.jogobonito.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MatchEventDTO {
    private Integer id;
    private Integer minute;
    private String description;
    private Integer matchId;
    private Integer playerId;
    private Integer player2Id;
    private Integer eventTypeId;
}

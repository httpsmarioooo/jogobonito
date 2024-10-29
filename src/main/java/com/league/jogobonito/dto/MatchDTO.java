package com.league.jogobonito.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MatchDTO {
    private Integer id;
    private Date date;
    private Integer homeTeamScore;
    private Integer awayTeamScore;

    private Integer stadiumId;
    private String stadiumName;

    // Si quieres también incluir el nombre del estadio
    private Integer homeTeamId;
    private String homeTeamName;

    private Integer awayTeamId;
    private String awayTeamName;

}

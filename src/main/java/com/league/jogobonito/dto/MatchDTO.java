package com.league.jogobonito.dto;

import com.league.jogobonito.domain.Stadium;
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
    private Integer teamId;
    private Integer teamId2;
}

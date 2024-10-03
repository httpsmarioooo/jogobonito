package com.league.jogobonito.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class JudgePerMatchDTO {

    private Integer id;
    private Integer matchId;
    private Integer judgeId;
    private Integer roleId;


}

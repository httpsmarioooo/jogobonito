package com.league.jogobonito.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CoachDTO {
    private Integer id;
    private String name;
    private Integer teamId;
}

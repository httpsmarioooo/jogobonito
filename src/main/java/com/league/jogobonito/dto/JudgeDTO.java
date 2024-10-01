package com.league.jogobonito.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class JudgeDTO {
    private Integer id;
    private String nombre;
    private String countryOfBirth;

}

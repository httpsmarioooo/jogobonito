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
public class PlayerDTO {
    private Integer id;
    private String name;
    private String position;
    private String jerseyNumber;
    private Date birthDate;
    private Integer heightCm;
    private String countryOfBirth;
    private Integer  teamId;
}

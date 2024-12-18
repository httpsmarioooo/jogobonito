package com.league.jogobonito.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TeamDTO {
    private Integer id;
    private String name; //text
    private String city;
    private String initial;
}

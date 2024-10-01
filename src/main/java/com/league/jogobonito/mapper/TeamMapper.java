package com.league.jogobonito.mapper;

import com.league.jogobonito.domain.Team;
import com.league.jogobonito.dto.TeamDTO;
import java.util.List;

public class TeamMapper {
    public static Team dtoToDomain(TeamDTO teamDTO){
        Team team = new Team();
        team.setId(teamDTO.getId());
        team.setName(teamDTO.getName());
        team.setCity(teamDTO.getCity());

        return team;
    }

    public static TeamDTO domainToDT0(Team team){
        return TeamDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .city(team.getCity())
                .build();
    }

    public static List<Team> dtoToDomainList(List<TeamDTO> teamsDTO){
        /*List<Team> teams = new ArrayList<>();

        for (TeamDTO teamDTO : teamsDTO){
            Team team = dtoToDomain(teamDTO);
            teams.add(team);
        }
        return teams;
        */

        return teamsDTO.stream().map(TeamMapper::dtoToDomain).toList();
    }

    public static List<TeamDTO>domainToDTOList(List<Team>teams){
        return teams.stream().map(TeamMapper::domainToDT0).toList();
    }
}

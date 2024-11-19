package com.league.jogobonito.mapper;

import com.league.jogobonito.domain.Goal;
import com.league.jogobonito.dto.GoalDTO;
import java.util.List;

public class GoalMapper {
    public static Goal dtoToDomain (GoalDTO goalDTO){
        return Goal.builder()
                .id(goalDTO.getId())
                .minute(goalDTO.getMinute())
                .build();
    }

    public static GoalDTO domainToDto (Goal goal){
        return GoalDTO.builder()
                .id(goal.getId())
                .minute(goal.getMinute())
                .playerId((goal.getPlayer() != null) ? goal.getPlayer().getId() : null)
                .matchId((goal.getMatch() != null) ? goal.getMatch().getId() : null)
                .build();
    }

    public static List<Goal> dtoToDomainList(List<GoalDTO>goalDTO){
        return goalDTO.stream().map(GoalMapper::dtoToDomain).toList();
    }

    public static List<GoalDTO> domainToDTOList(List<Goal> goals){
        return goals.stream().map(GoalMapper::domainToDto).toList();
    }
}

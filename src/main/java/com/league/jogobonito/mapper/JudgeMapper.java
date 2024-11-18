package com.league.jogobonito.mapper;

import com.league.jogobonito.domain.Judge;
import com.league.jogobonito.dto.JudgeDTO;

import java.util.List;

public class JudgeMapper {
    public static Judge dtoToDomain(JudgeDTO judgeDTO){
        Judge judge = new Judge();
        judge.setId(judgeDTO.getId());
        judge.setName(judgeDTO.getName());
        judge.setCountryOfBirth(judgeDTO.getCountryOfBirth());
        return judge;
    }

    public static JudgeDTO domainToDto(Judge judge){
        return JudgeDTO.builder().
                id(judge.getId()).
                name(judge.getName()).
                countryOfBirth(judge.getCountryOfBirth()).
                build();
    }

    public static List<Judge> dtoToDomainList(List<JudgeDTO> judgesDTO){
        return judgesDTO.stream().map(JudgeMapper::dtoToDomain).toList();
    }

    public static List<JudgeDTO>domainToDTOList(List<Judge> judges){
        return judges.stream().map(JudgeMapper::domainToDto).toList();
    }

}

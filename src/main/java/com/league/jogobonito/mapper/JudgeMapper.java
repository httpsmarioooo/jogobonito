package com.league.jogobonito.mapper;

import com.league.jogobonito.domain.Judge;
import com.league.jogobonito.dto.JudgeDTO;

import java.util.List;

public class JudgeMapper {
    public static Judge dtoToDomain(JudgeDTO judgeDTO){
        Judge judge = new Judge();
        judge.setId(judgeDTO.getId());
        judge.setName(judgeDTO.getNombre());
        judge.setCountryOfBirth(judgeDTO.getCountryOfBirth());

        return judge;
    }

    public static JudgeDTO domainToDTO(Judge judge){
        return JudgeDTO.builder().
                id(judge.getId()).
                nombre(judge.getName()).
                countryOfBirth(judge.getCountryOfBirth()).
                build();
    }

    public static List<Judge> dtoDomainList(List<JudgeDTO> judgesDTO){
        return judgesDTO.stream().map(JudgeMapper::dtoToDomain).toList();
    }

    public static List<JudgeDTO>domainToDTOList(List<Judge> judges){
        return judges.stream().map(JudgeMapper::domainToDTO).toList();
    }

}

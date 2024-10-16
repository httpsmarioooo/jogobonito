package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.Award;
import com.league.jogobonito.domain.Player;
import com.league.jogobonito.dto.AwardDTO;
import com.league.jogobonito.dto.PlayerDTO;
import com.league.jogobonito.mapper.AwardMapper;
import com.league.jogobonito.mapper.PlayerMapper;
import com.league.jogobonito.repository.AwardRepository;
import com.league.jogobonito.repository.PlayerRepository;
import com.league.jogobonito.service.AwardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AwardServiceImpl implements AwardService {


    private final AwardRepository awardRepository;

    private final PlayerRepository playerRepository;

    public AwardServiceImpl(AwardRepository awardRepository, PlayerRepository playerRepository) {
        this.awardRepository = awardRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public AwardDTO guardarNuevoAward(AwardDTO awardDTO) throws Exception {

        if(awardDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (awardDTO.getName() == null || awardDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (awardDTO.getDescription() == null || awardDTO.getDescription().isBlank()) {
            throw new Exception("La descripcion no debe ser nulo o vacío");
        }

        if(awardDTO.getPlayerId() == null) {
            throw new Exception("El PlayerId no debe ser nulo");
        }


        //Ultimas validaciones en el mismo impl en la parte final---
        Award award = AwardMapper.dtoToDomain(awardDTO);
        Player player = playerRepository.getReferenceById(awardDTO.getPlayerId());

        if (player == null){
            throw new Exception("El Player no existe");
        }

        award.setPlayer(player);
        award = awardRepository.save(award);
        return AwardMapper.domainToDto(award);
    }

    @Override
    @Transactional(readOnly = true)
    public AwardDTO buscarAwardPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }


        Award award = awardRepository.getReferenceById(id);
        if (award == null) {
            throw new Exception("No se encuentra el player con el id"+id);
        }

        AwardDTO awardDTO = AwardMapper.domainToDto(award);
        return awardDTO;
    }


    @Override
    public AwardDTO modificarAward(AwardDTO awardDTO) throws Exception {
        if(awardDTO.getId() == null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (awardDTO.getName() == null || awardDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (awardDTO.getDescription() == null || awardDTO.getDescription().isBlank()) {
            throw new Exception("La descripcion no debe ser nulo o vacío");
        }

        if(awardDTO.getPlayerId() == null) {
            throw new Exception("El PlayerId no debe ser nulo");
        }


        //Ultimas validaciones en el mismo impl en la parte final---
        Award award = AwardMapper.dtoToDomain(awardDTO);
        Player player = playerRepository.getReferenceById(awardDTO.getPlayerId());

        if (player == null){
            throw new Exception("El Player no existe");
        }

        award.setPlayer(player);
        award = awardRepository.save(award);

        return AwardMapper.domainToDto(award);
    }
}

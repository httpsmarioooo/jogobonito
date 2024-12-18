package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.Award;
import com.league.jogobonito.domain.Player;
import com.league.jogobonito.dto.AwardDTO;
import com.league.jogobonito.mapper.AwardMapper;
import com.league.jogobonito.repository.AwardRepository;
import com.league.jogobonito.repository.PlayerRepository;
import com.league.jogobonito.service.AwardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AwardServiceImpl implements AwardService {


    private final AwardRepository awardRepository;

    private final PlayerRepository playerRepository;

    public AwardServiceImpl(AwardRepository awardRepository, PlayerRepository playerRepository) {
        this.awardRepository = awardRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
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
//        Player player = playerRepository.getReferenceById(awardDTO.getPlayerId());
//        if (player == null){
//            throw new Exception("El Award no existe");
//        }
//        award.setPlayer(player);

        Player player = playerRepository.findById(awardDTO.getPlayerId())
                .orElseThrow(() -> new Exception("El Player no existe"));
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

        Award award = awardRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el Coach con el id " +id));
        return AwardMapper.domainToDto(award);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public AwardDTO modificarAward(AwardDTO awardDTO) throws Exception {
        if(awardDTO.getId() == null) {
            throw new Exception("El id no debe de ser nulo");
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
//        Player player = playerRepository.getReferenceById(awardDTO.getPlayerId());
//        if (player == null){
//            throw new Exception("El Award no existe");
//        }
//        award.setPlayer(player);

        Player player = playerRepository.findById(awardDTO.getPlayerId())
                .orElseThrow(() -> new Exception("El Player no existe"));
        award.setPlayer(player);

        award = awardRepository.save(award);
        return AwardMapper.domainToDto(award);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AwardDTO> obtenerAwards() {
        List<Award>listaAwards = awardRepository.findAll();
        List<AwardDTO>awardsDTO = AwardMapper.domainToDTOList(listaAwards);
        return AwardMapper.domainToDTOList(listaAwards);
    }
}
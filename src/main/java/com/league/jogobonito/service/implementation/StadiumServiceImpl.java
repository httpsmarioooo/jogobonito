package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.Stadium;
import com.league.jogobonito.dto.StadiumDTO;
import com.league.jogobonito.mapper.StadiumMapper;
import com.league.jogobonito.repository.StadiumRepository;
import com.league.jogobonito.service.StadiumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StadiumServiceImpl implements StadiumService {
    private final StadiumRepository stadiumRepository;

    public StadiumServiceImpl(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public StadiumDTO guardarNuevoStadium(StadiumDTO stadiumDTO) throws Exception {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public StadiumDTO buscarStadiumPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        Stadium stadium = stadiumRepository.findById(id)
         .orElseThrow (() -> new Exception("No se encuentra el jugador con el id" +id));

        return StadiumMapper.domainToDto(stadium);

        /*if (stadium == null) {
            throw new Exception("No se encuentra el player con el id"+id);
        }
         */
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public StadiumDTO modificarStadium(StadiumDTO stadiumDTO) throws Exception {
        return null;
    }
}

package com.league.jogobonito.service.implementation;

import com.league.jogobonito.domain.Stadium;
import com.league.jogobonito.dto.StadiumDTO;
import com.league.jogobonito.mapper.StadiumMapper;
import com.league.jogobonito.repository.MatchRepository;
import com.league.jogobonito.repository.StadiumRepository;
import com.league.jogobonito.service.StadiumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StadiumServiceImpl implements StadiumService {

    private final StadiumRepository stadiumRepository;
    private final MatchRepository matchRepository;

    public StadiumServiceImpl(StadiumRepository stadiumRepository, MatchRepository matchRepository ) {
        this.stadiumRepository = stadiumRepository;
        this. matchRepository = matchRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public StadiumDTO guardarNuevoStadium(StadiumDTO stadiumDTO) throws Exception {

        if(stadiumDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (stadiumDTO.getName() == null || stadiumDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (stadiumDTO.getCity() == null || stadiumDTO.getCity().isBlank()) {
            throw new Exception("La ciudad no debe ser nulo o vacío");
        }

        if(stadiumDTO.getCapacity() == null) {
            throw new Exception("La capacidad no debe de ser nulo");
        }

        if (stadiumDTO.getCountry() == null || stadiumDTO.getCountry().isBlank()) {
            throw new Exception("El pais no debe ser nulo o vacío");
        }

        Stadium stadium = StadiumMapper.dtoToDomain(stadiumDTO);
        stadium = stadiumRepository.save(stadium);
        return StadiumMapper.domainToDto(stadium);

    }

    @Override
    @Transactional(readOnly = true)
    public StadiumDTO buscarStadiumPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        Stadium stadium = stadiumRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el Stadium con el id " +id));
        return StadiumMapper.domainToDto(stadium);

        /*if (stadium == null) {
            throw new Exception("No se encuentra el player con el id"+id);
        }
         */
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public StadiumDTO modificarStadium(StadiumDTO stadiumDTO) throws Exception {
        if(stadiumDTO.getId() == null) {
            throw new Exception("El id no puede ser nulo");
        }

        if (stadiumDTO.getName() == null || stadiumDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (stadiumDTO.getCity() == null || stadiumDTO.getCity().isBlank()) {
            throw new Exception("La ciudad no debe ser nulo o vacío");
        }

        if(stadiumDTO.getCapacity() == null) {
            throw new Exception("La capacidad no debe de ser nulo");
        }

        if (stadiumDTO.getCountry() == null || stadiumDTO.getCountry().isBlank()) {
            throw new Exception("El pais no debe ser nulo o vacío");
        }

        Stadium stadium = StadiumMapper.dtoToDomain(stadiumDTO);
        stadium = stadiumRepository.save(stadium);
        return StadiumMapper.domainToDto(stadium);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StadiumDTO> obtenerStadiums() {
        List<Stadium>listaStadiums = stadiumRepository.findAll();
        List<StadiumDTO>stadiumDTO = StadiumMapper.domainToDTOList(listaStadiums);
        return StadiumMapper.domainToDTOList(listaStadiums);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void eliminarStadium(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id no puede ser nulo o cero");
        }

        Boolean existeStadium = stadiumRepository.existsById(id);
        if (existeStadium == false) {
            throw new Exception("El id del stadium no existe " +id+". Por lo tanto no se puede eliminar");
        }


        Boolean existeAlgunStadiumAsociadoAMatch = matchRepository.existsByStadiumId(id);
        if (existeAlgunStadiumAsociadoAMatch) {
            throw new Exception("El Stadium con el id"+id+"tiene matches asociados por lo tanto no se puede eliminar");
        }

        stadiumRepository.deleteById(id);
    }
}

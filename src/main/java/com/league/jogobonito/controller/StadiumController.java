package com.league.jogobonito.controller;

import com.league.jogobonito.domain.Stadium;
import com.league.jogobonito.dto.StadiumDTO;
import com.league.jogobonito.mapper.StadiumMapper;
import com.league.jogobonito.repository.StadiumRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stadium")
public class StadiumController {
    private StadiumRepository stadiumRepository;

    public StadiumController(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    @GetMapping(value = "/obtenerStadiums")
    public List<StadiumDTO> obtenerStadiums() {
        List<Stadium> listaStadiums = stadiumRepository.findAll();
        List<StadiumDTO> stadiumDTO = StadiumMapper.domainToDTOList(listaStadiums);  // Cambiado a StadiumMapper

        return stadiumDTO;
    }

    @PostMapping(value = "/crearNuevoStadium")
    public ResponseEntity<StadiumDTO> crearNuevoStadium(@RequestBody StadiumDTO stadiumDTO) {
        StadiumDTO stadiumDTOResponse = null;

        Stadium stadium = StadiumMapper.dtoToDomain(stadiumDTO);
        stadium = stadiumRepository.save(stadium);

        stadiumDTOResponse = StadiumMapper.domainToDTO(stadium);  // Cambiado el nombre de la variable

        return new ResponseEntity<>(stadiumDTOResponse, HttpStatus.CREATED);  // Variable en minúsculas
    }
}

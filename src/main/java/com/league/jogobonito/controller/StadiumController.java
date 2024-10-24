package com.league.jogobonito.controller;

import com.league.jogobonito.dto.StadiumDTO;
import com.league.jogobonito.service.StadiumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stadium")
public class StadiumController {
    private StadiumService stadiumService;


    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    /*@PostMapping(value = "/crearNuevoStadium")
    public ResponseEntity<StadiumDTO> crearNuevoStadium(@RequestBody StadiumDTO stadiumDTO) {
        StadiumDTO stadiumDTOResponse = null;
        Stadium stadium = StadiumMapper.dtoToDomain(stadiumDTO);
        stadium = stadiumRepository.save(stadium);
        stadiumDTOResponse = StadiumMapper.domainToDto(stadium);  // Cambiado el nombre de la variable
        return new ResponseEntity<>(stadiumDTOResponse, HttpStatus.CREATED);  // Variable en minúsculas
    }
     */

    @PostMapping(value = "/guardarNuevoStadium")
    public ResponseEntity<StadiumDTO> guardarNuevoStadium(@RequestBody StadiumDTO stadiumDTO) throws Exception {
        StadiumDTO stadiumResponse = stadiumService.guardarNuevoStadium(stadiumDTO);
        return new ResponseEntity<>(stadiumResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerStadium")
    public List<StadiumDTO>obtenerStadium(){
        return stadiumService.obtenerStadiums();
    }

    @GetMapping("/buscarStadiumPorId/{id}")
    public ResponseEntity<StadiumDTO> buscarStadiumPorId (Integer id)throws Exception {
        StadiumDTO stadiumResponse = stadiumService.buscarStadiumPorId(id);
        return new ResponseEntity<>(stadiumResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarStadium")
    public ResponseEntity<StadiumDTO> modificarStadium(@RequestBody StadiumDTO stadiumDTO) throws Exception {
        StadiumDTO stadiumResponse = stadiumService.modificarStadium(stadiumDTO);
        return new ResponseEntity<>(stadiumResponse, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/eliminarStadium/{id}")
    public ResponseEntity<Void> eliminarStadium(@PathVariable("id") Integer idStadium) throws Exception {
        stadiumService.eliminarStadium(idStadium);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

package com.league.jogobonito.controller;
import com.league.jogobonito.domain.Player;
import com.league.jogobonito.repository.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/player")
public class playerController {
    private PlayerRepository playerRepository;
    public playerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping(value = "/obtenerPlayers")
    public List<Player> obtenerPlayers() {
        return playerRepository.findAll();
    }
}

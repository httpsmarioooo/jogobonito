package com.league.jogobonito.repository;

import com.league.jogobonito.domain.Player;
import com.league.jogobonito.domain.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testExistsPlayerId() {

        // Persistir el equipo
        Team team = Team.builder()
                .name("Once")
                .city("Manizales")
                .initial("OCC")
                .build();
        entityManager.persist(team);

        // Convertir LocalDate a java.util.Date
        Date birthDate = Date.from(LocalDate.of(1995, 5, 20).atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Crear y persistir el jugador
        Player player = Player.builder()
                .name("John")
                .position("Delantero")
                .jerseyNumber("10")
                .heightCm(122)
                .countryOfBirth("Senegal")
                .birthDate(birthDate) // Usamos el Date convertido
                .team(team)
                .build();
        player = entityManager.persist(player); // Persistimos y obtenemos el ID generado

        // Verificar si existe en el repositorio
        Boolean exists = playerRepository.existsById(player.getId());

        // Asegurarse de que el jugador existe
        Assertions.assertTrue(exists, "El jugador debería existir en la base de datos.");
    }

}


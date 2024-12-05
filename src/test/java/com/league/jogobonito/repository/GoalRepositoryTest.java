package com.league.jogobonito.repository;

import com.league.jogobonito.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class GoalRepositoryTest {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testExistsByGoalId() {
        // Crea y persiste un equipo
        Team team = Team.builder()
                .name("Real Madrid")
                .city("Madrid")
                .build();
        entityManager.persist(team);

        // Crea y persiste un estadio
        Stadium stadium = Stadium.builder()
                .name("Santiago Bernabéu")
                .city("Madrid")
                .capacity(81000)
                .country("España")
                .build();
        entityManager.persist(stadium);

        // Crea y persiste un jugador asociado al equipo
        Player player = Player.builder()
                .name("Karim Benzema")
                .position("Forward")
                .team(team)
                .jerseyNumber("9")
                .birthDate(new Date())
                .heightCm(185)
                .countryOfBirth("Francia")
                .build();
        entityManager.persist(player);

        // Crea y persiste un partido asociado al equipo y estadio
        Match match = Match.builder()
                .date(new Date())
                .homeTeamScore(2)
                .awayTeamScore(1)
                .stadium(stadium) // Asocia el estadio aquí
                .team(team)       // Equipo local
                .team2(team)      // Equipo visitante (puede ser diferente en casos reales)
                .build();
        entityManager.persist(match);

        // Crea y persiste un gol asociado al partido y al jugador
        Goal goal = Goal.builder()
                .minute(23)      // Minuto del gol
                .match(match)    // Partido asociado
                .player(player)// Jugador que marcó el gol
                .build();
        entityManager.persist(goal);

        // Verifica si el gol existe por su ID
        Boolean exists = goalRepository.existsById(goal.getId());

        // Asegúrate de que el gol existe
        Assertions.assertTrue(exists, "El gol debería existir en la base de datos.");
    }
}

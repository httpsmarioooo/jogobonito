package com.league.jogobonito.repository;

import com.league.jogobonito.domain.Match;
import com.league.jogobonito.domain.Stadium;
import com.league.jogobonito.domain.Team;
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
public class MatchRepositoryTest {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testExistsByStadiumId() {
        // Crea y persiste el equipo local
        Team homeTeam = Team.builder()
                .name("Real Madrid")
                .city("Madrid")
                .initial("RM")
                .build();
        entityManager.persist(homeTeam);

        // Crea y persiste el equipo visitante
        Team awayTeam = Team.builder()
                .name("Barcelona")
                .city("Barcelona")
                .initial("BAR")
                .build();
        entityManager.persist(awayTeam);

        // Crea y persiste el estadio
        Stadium stadium = Stadium.builder()
                .name("Santiago Bernabéu")
                .city("Madrid")
                .capacity(81044)
                .country("España")
                .build();
        entityManager.persist(stadium);

        // Crea y persiste el partido
        Match match = Match.builder()
                .date(new Date())       // Fecha del partido
                .homeTeamScore(3)       // Marcador del equipo local
                .awayTeamScore(1)       // Marcador del equipo visitante
                .stadium(stadium)       // Estadio del partido
                .team(homeTeam)         // Equipo local
                .team2(awayTeam)        // Equipo visitante
                .build();
        entityManager.persist(match);

        // Llama al método que se está probando
        Boolean exists = matchRepository.existsByStadiumId(stadium.getId());

        // Verifica que el resultado sea el esperado
        Assertions.assertTrue(exists, "Debería existir un partido asociado al estadio");
    }
}

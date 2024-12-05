package com.league.jogobonito.repository;

import com.league.jogobonito.domain.Award;
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
public class AwardRepositoryTest {

    @Autowired
    private AwardRepository awardRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testExistsByPlayerId() {
        // Crea y persiste el jugador

        Team team = Team.builder()
                .name("Once")
                .city("Manizales")
                .initial("OCC")
                .build();
        entityManager.persist(team);

        Date birthDate = Date.from(LocalDate.of(1995, 5, 20).atStartOfDay(ZoneId.systemDefault()).toInstant());

        Player player = Player.builder()
                .name("Lionel Messi")
                .position("Forward")
                .team(team)
                .jerseyNumber("10")
                .birthDate(birthDate)
                .heightCm(170)
                .countryOfBirth("Argentina")
                .build();
        entityManager.persist(player);

        // Crea y persiste el premio (Award)
        Award award = Award.builder()
                .name("Ballon d'Or")
                .description("sed")
                .player(player)
                .build();
        entityManager.persist(award);

        // Llama al método que se está probando
        Boolean exists = awardRepository.existsById(award.getId());

        // Verifica que el resultado sea el esperado
        Assertions.assertTrue(exists, "Debería existir un premio asociado al jugador");
    }
}

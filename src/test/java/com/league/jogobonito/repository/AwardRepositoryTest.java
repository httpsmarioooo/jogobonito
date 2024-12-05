package com.league.jogobonito.repository;

import com.league.jogobonito.domain.Award;
import com.league.jogobonito.domain.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
        Player player = Player.builder()
                .name("Lionel Messi")
                .position("Forward")
                .jerseyNumber("10")
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
        Boolean exists = awardRepository.existsById(player.getId());

        // Verifica que el resultado sea el esperado
        Assertions.assertTrue(exists, "Debería existir un premio asociado al jugador");
    }
}

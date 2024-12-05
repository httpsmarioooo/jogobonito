package com.league.jogobonito.repository;

import com.league.jogobonito.domain.Standing;
import com.league.jogobonito.domain.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StandingRepositoryTest {

    @Autowired
    private StandingRepository standingRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testExistsManager(){
        Team team = Team.builder()
                .name("Once")
                .city("Manizales")
                .initial("OCC")
                .build();
        entityManager.persist(team);


        Standing standing = Standing.builder()
                .team(team)
                .points(12)
                .goalsFor(2)
                .goalsAgainst(1)
                .build();

        entityManager.persist(standing);

        Boolean exists = standingRepository.existsById(standing.getId());

        // Asegurarse de que el jugador existe
        Assertions.assertTrue(exists, "El Standing debería existir en la base de datos.");
    }
}

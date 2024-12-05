package com.league.jogobonito.repository;

import com.league.jogobonito.domain.Coach;
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
public class CoachRepositoryTest {

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testExistsByCoachId() {
        // Crea y persiste un equipo
        Team team = Team.builder()
                .name("Real Madrid")
                .city("Madrid")
                .initial("RM")
                .build();
        entityManager.persist(team);

        // Crea y persiste un entrenador asociado al equipo
        Coach coach = Coach.builder()
                .name("Alfredo Valenzuela")
                .team(team)
                .build();
        entityManager.persist(coach);

        // Verifica si existe un entrenador por su ID
        Boolean exists = coachRepository.existsById(coach.getId());

        // Asegúrate de que el entrenador existe
        Assertions.assertTrue(exists, "El entrenador debería existir en la base de datos.");
    }
}

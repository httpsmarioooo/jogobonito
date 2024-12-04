package com.league.jogobonito.repository;

import com.league.jogobonito.domain.Team;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    //void no retoma nada
    @DisplayName("Test guardar nuevo equipo")
    @Test
    void guardarTeam(){
        //Definir la precondicion
        Team team = Team.builder()
                .name("Real Madrid")
                .city("Madrid")
                .initial("RMD")
//                .id(null)
                .build();

        //Accion del usuario
        Team team1 = teamRepository.save(team);

        //La salida osea la repuesta

        assertThat(team1.getName()).isEqualTo("Real Madrid");
        assertThat(team1.getCity()).isEqualTo("Madrid");
        assertThat(team1.getInitial()).isEqualTo("RMD");
//        assertThat(team1.getId()).isNull();
    }
}

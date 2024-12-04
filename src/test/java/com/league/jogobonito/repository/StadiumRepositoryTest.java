package com.league.jogobonito.repository;

import com.league.jogobonito.domain.Stadium;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class StadiumRepositoryTest {

    @Autowired
    private StadiumRepository stadiumRepository;

    @DisplayName("Test para guardar nuevo Estadio")
    @Test
    void guardarEstadio(){
        Stadium stadium = Stadium.builder()
                //.id(null)
                .name("El Campin")
                .city("Bogota")
                .capacity(45000)
                .country("Colombia")
                .build();

        Stadium stadium1 = stadiumRepository.save(stadium);
        //assertThat(stadium1.getId()).isNull();
        assertThat(stadium1.getName()).isEqualTo("El Campin");
        assertThat(stadium1.getCity()).isEqualTo("Bogota");
        assertThat(stadium1.getCapacity()).isEqualTo(45000);
        assertThat(stadium1.getCountry()).isEqualTo("Colombia");
    }
}

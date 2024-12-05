package com.league.jogobonito.repository;

import com.league.jogobonito.domain.EventType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EventTypeRepositoryTest {

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @DisplayName("Test para guardar EventType")
    @Test
    public void guardarEventType() {
        EventType eventType = EventType.builder()
                .name("Penalti")
                .build();

        EventType eventType1 = eventTypeRepository.save(eventType);
        assertThat(eventType.getName()).isEqualTo("Penalti");
    }
}

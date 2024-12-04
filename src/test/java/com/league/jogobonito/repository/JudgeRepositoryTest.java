package com.league.jogobonito.repository;

import com.league.jogobonito.domain.Judge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JudgeRepositoryTest {

    @Autowired
    private JudgeRepository judgeRepository;


    @DisplayName("Test guardar nuevo judge")
    @Test

    void guardarJudge() {
        Judge judge = Judge.builder()
                .name("Oscar")
                .build();

        Judge judge1 = judgeRepository.save(judge);

        assertThat(judge1.getName()).isEqualTo("Oscar");
    }
}




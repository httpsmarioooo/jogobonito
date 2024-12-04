package com.league.jogobonito.repository;

import com.league.jogobonito.domain.JudgeRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JudgeRoleRepositoryTest {

    @Autowired
    private JudgeRoleRepository judgeRoleRepository;

    @DisplayName("Test guardar el roje del judge")
    @Test

    void guardarJudgeRole() {
        JudgeRole judgeRole = JudgeRole.builder()
                .roleName("VAR")
                .build();

        JudgeRole judgeRole1 = judgeRoleRepository.save(judgeRole);

        assertThat(judgeRole.getRoleName()).isEqualTo("VAR");
    }
}

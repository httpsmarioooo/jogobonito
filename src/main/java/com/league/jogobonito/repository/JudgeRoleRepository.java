package com.league.jogobonito.repository;

import com.league.jogobonito.domain.JudgeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgeRoleRepository extends JpaRepository<JudgeRole, Integer> {
}

package com.league.jogobonito.repository;

import com.league.jogobonito.domain.Assist;
import com.league.jogobonito.domain.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardRepository extends JpaRepository<Award, Integer> {
}

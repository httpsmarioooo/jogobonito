package com.league.jogobonito.repository;

import com.league.jogobonito.domain.Standing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandingRepository extends JpaRepository<Standing, Integer> {
}

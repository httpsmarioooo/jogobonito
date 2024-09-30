package com.league.jogobonito.repository;
import com.league.jogobonito.domain.JudgesPerMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgesPerMatchRepository extends JpaRepository<JudgesPerMatch, Integer> {
}

package com.league.jogobonito.repository;
import com.league.jogobonito.domain.JudgePerMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgePerMatchRepository extends JpaRepository<JudgePerMatch, Integer> {
}

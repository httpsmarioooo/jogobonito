package com.league.jogobonito.repository;
import com.league.jogobonito.domain.Judge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgeRepository extends JpaRepository<Judge, Integer> {
}

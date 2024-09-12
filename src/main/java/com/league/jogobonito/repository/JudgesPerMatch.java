package com.league.jogobonito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgesPerMatch extends JpaRepository<Judge, Integer> {
}

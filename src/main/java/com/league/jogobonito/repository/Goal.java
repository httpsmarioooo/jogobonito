package com.league.jogobonito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Goal extends JpaRepository<Goal, Integer> {
}

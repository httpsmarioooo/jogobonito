package com.league.jogobonito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Stadium extends JpaRepository<Stadium, Integer> {
}

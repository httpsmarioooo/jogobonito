package com.league.jogobonito.repository;
import com.league.jogobonito.domain.MatchEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchEventRepository extends JpaRepository<MatchEvent, Integer> {
}

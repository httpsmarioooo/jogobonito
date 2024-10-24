package com.league.jogobonito.repository;
import com.league.jogobonito.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

    Boolean existsByStadiumId(Integer stadiumId);
}

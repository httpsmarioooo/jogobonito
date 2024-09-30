package com.league.jogobonito.repository;
import com.league.jogobonito.domain.Assist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistRepository extends JpaRepository<Assist, Integer> {
}



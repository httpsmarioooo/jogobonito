package com.league.jogobonito.repository;


import io.micrometer.observation.Observation;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchEventRepository extends Observation.Event {
}
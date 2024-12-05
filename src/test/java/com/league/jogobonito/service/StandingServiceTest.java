package com.league.jogobonito.service;

import com.league.jogobonito.domain.Standing;
import com.league.jogobonito.domain.Team;
import com.league.jogobonito.repository.StandingRepository;
import com.league.jogobonito.service.implementation.StandingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StandingServiceTest {

    @Mock
    private StandingRepository standingRepository;

    @InjectMocks
    private StandingServiceImpl standingService;

    @Test
    public void testObtenerStandings() {
        Team teamMock = Team.builder()
                .id(1)
                .name("Team 1")
                .city("Uruguay")
                .build();

        List<Standing> standingsMock = List.of(
                Standing.builder()
                        .id(1)
                        .points(6)
                        .goalsFor(5)
                        .goalsAgainst(2)
                        .team(teamMock)
                        .build()
        );
        Mockito.when(standingRepository.findAll()).thenReturn(standingsMock);
    }
}

package com.league.jogobonito.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "match_events")

public class MatchEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer minute;

    @Column
    private String description;


    @ManyToOne
    @JoinColumn(name = "match_id", referencedColumnName = "id", nullable = false)
    private MatchEvent matchEvent;

    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id", nullable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "player2_id", referencedColumnName = "id", nullable = false)
    private Player player2;

}



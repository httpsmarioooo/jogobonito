package com.league.jogobonito.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "matches")

public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable = false)
    private Integer homeTeamScore;

    @Column(nullable = false)
    private Integer awayTeamScore;

    @ManyToOne
    @JoinColumn (name = "stadium_id" , referencedColumnName = "id", nullable = false)
    private Stadium stadium;

    @ManyToOne
    @JoinColumn (name = "home_team_id", referencedColumnName = "id" , nullable = false)
    private Team team;

    @ManyToOne
    @JoinColumn (name = "away_team_id", referencedColumnName = "id" , nullable = false)
    private Team team2;




}

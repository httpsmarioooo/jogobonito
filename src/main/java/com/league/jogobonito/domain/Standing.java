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
@Table(name = "standings")
public class Standing {

    @Id
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    private Team team;

    @Column(nullable = false)
    private Integer points;

    @Column(nullable = false, name = "goals_for")
    private Integer goalsFor;

    @Column(nullable = false, name = "goals_against")
    private Integer goalsAgainst;

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer points;

    @Column(nullable = false, name = "goals_for")
    private Integer goalsFor;

    @Column(nullable = false, name = "goals_against")
    private Integer goalsAgainst;

    @ManyToOne
    @JoinColumn (name = "team_id" , referencedColumnName = "id", nullable = false)
    private Team team;*/

}

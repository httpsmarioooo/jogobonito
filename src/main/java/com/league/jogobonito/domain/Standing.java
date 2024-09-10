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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer points;

    @Column(nullable = false)
    private Integer goalsFor;

    @Column(nullable = false)
    private Integer goalsAgainst;

    @ManyToOne
    @JoinColumn (name = "team_id" , referencedColumnName = "id", nullable = false)
    private Team team;

}

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
@Table(name = "players")

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false, length = 3, name = "jersey_number")
    private String jerseyNumber;

    @Column(nullable = false, name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(nullable = false, name = "height_cm")
    private Integer heightCm;

    @Column(nullable = false, name = "country_of_birth")
    private String countryOfBirth;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    private Team team;
}


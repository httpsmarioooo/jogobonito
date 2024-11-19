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
@Table(name = "judges_per_match")

public class JudgePerMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "judge_id", referencedColumnName = "id", nullable = false)
    private Judge judge;

    @ManyToOne
    @JoinColumn (name = "match_id" , referencedColumnName =  "id" , nullable = false)
    private Match match;

    @ManyToOne
    @JoinColumn (name = "role_id" , referencedColumnName = "id", nullable = false)
    private JudgeRole judgeRole;
}


package com.HiringPlarform.HiringPlatform.model.entity.tables;

import com.HiringPlarform.HiringPlatform.model.entity.enums.RoundType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "round")
public class Rounds {

    @Id
    private String roundsId;

    @Enumerated(EnumType.STRING)
    private RoundType roundType;

    @ManyToOne
    @JoinColumn(name = "contest_id", nullable = false)
    private Contest contest;

    private int participantsCounts;

    @Override
    public String toString() {
        return "Rounds{" +
                "roundsId='" + roundsId + '\'' +
                ", roundType=" + roundType +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @OneToMany(mappedBy = "rounds", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("rounds")
    private List<Part> parts;

    @OneToMany(mappedBy = "rounds")
    @JsonIgnoreProperties("rounds")
    private List<Interview> interviews;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private int roundNumber;
    private int pass;

}

package com.HiringPlarform.HiringPlatform.model.entity.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.Duration;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "part_table")
public class Part {

    @Id
    private String partId;

    private int easy;
    private int medium;
    private int hard;

    @ManyToOne
    @JoinColumn(name = "rounds_id")
    private Rounds rounds;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Duration assignedTime;
}

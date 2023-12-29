package com.HiringPlarform.HiringPlatform.model.entity.tables;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "part_table")
public class Part {

    @Id
    private String partId;
    private int easy;
    private int medium;
    private int hard;

    @OneToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    private Time assignedTime;

    @ManyToOne
    @JoinColumn(name = "contest_id")
    private Contest contest;
}


package com.HiringPlarform.HiringPlatform.model.entity.tables;


import com.HiringPlarform.HiringPlatform.model.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    @Enumerated(EnumType.STRING)
    private Category category;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
}

package com.HiringPlarform.HiringPlatform.model.entity.tables;


import com.HiringPlarform.HiringPlatform.model.entity.enums.ContestType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "contest_table")
public class Contest {

    @Id
    private String contestId;

    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;

    private int passMark;

    @OneToMany(mappedBy = "contest", cascade = CascadeType.ALL)
    private List<Part> parts;

    @OneToMany(mappedBy = "contest", cascade = CascadeType.ALL)
    private List<User> users;

    @Enumerated(EnumType.STRING)
    private ContestType contestType;

    @OneToMany(mappedBy = "contest", cascade = CascadeType.ALL)
    private List<Interview> interviews;

    private int interviewSelected;
}
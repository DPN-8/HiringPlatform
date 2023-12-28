package com.HiringPlarform.HiringPlatform.model.entity.tables;


import com.HiringPlarform.HiringPlatform.model.enums.ContestType;
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

    @OneToMany
    @JoinColumn(name = "contest_id")
    private List<User> users;

    @OneToMany
    @JoinColumn(name = "partId")
    private List<Part> parts;

    @OneToMany
    @JoinColumn(name = "resultId")
    private List<MultipleChoiceQuestionResult> multipleChoiceQuestionResults;

    @Enumerated(EnumType.STRING)
    private ContestType contestType;

}

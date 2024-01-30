package com.HiringPlarform.HiringPlatform.model.entity.tables;


import com.HiringPlarform.HiringPlatform.model.entity.enums.InterviewResult;
import com.HiringPlarform.HiringPlatform.model.entity.enums.InterviewType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "interview")
@Data
public class Interview {

    @Id
    private String interviewId;

    @OneToOne
    @JoinColumn(name = "userId")
    @JsonIgnoreProperties("contest")
    private User user;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    @JsonIgnoreProperties("contest")
    private Employee employee;

    @Enumerated(EnumType.STRING)
    private InterviewType interviewType;

    private String feedBack;

    @Enumerated(EnumType.STRING)
    private InterviewResult interviewResult;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "roundsId")
    private Rounds rounds;

    private LocalDateTime interviewTime;
}


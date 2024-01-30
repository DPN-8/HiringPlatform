package com.HiringPlarform.HiringPlatform.model.entity.tables;

import com.HiringPlarform.HiringPlatform.model.entity.enums.CasesType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "cases")
public class Cases {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long caseId;

    private String input;
    private String output;

    @Enumerated(EnumType.STRING)
    private CasesType casesType;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private CodingQuestion codingQuestion;
}

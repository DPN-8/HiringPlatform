package com.HiringPlarform.HiringPlatform.model.entity.tables;

import com.HiringPlarform.HiringPlatform.model.entity.enums.Difficulty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "coding_table")
public class CodingQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private Long questionId;

    @Column(length = 1000)
    private String question;

    @OneToMany(mappedBy = "codingQuestion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cases> casesList;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
}

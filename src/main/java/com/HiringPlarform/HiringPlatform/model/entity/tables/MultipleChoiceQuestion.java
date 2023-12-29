package com.HiringPlarform.HiringPlatform.model.entity.tables;


import com.HiringPlarform.HiringPlatform.model.entity.enums.Difficulty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "mcq_table")
public class MultipleChoiceQuestion {

    @Id
    private String question_id;

    @Column(length = 1000)
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne
    @JoinColumn(name = "categoryId")
    private Category category;
}

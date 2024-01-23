package com.HiringPlarform.HiringPlatform.model.entity.tables;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "options_table")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private MultipleChoiceQuestion multipleChoiceQuestion;

    private String option;
    @Override
    public String toString() {
        return "Options{" +
                "id=" + id +
                ", multipleChoiceQuestion=" + multipleChoiceQuestion +
                ", option='" + option + '\'' +
                '}';
    }

}

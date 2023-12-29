package com.HiringPlarform.HiringPlatform.model.entity.tables;


import com.HiringPlarform.HiringPlatform.converters.MapToStringConverter;
import com.HiringPlarform.HiringPlatform.model.enums.Result;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "mcq_result_table")
public class MultipleChoiceQuestionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long resultId;

    private String userId;

    @Column(length = 1000)
    @Convert(converter = MapToStringConverter.class)
    private Map<String, String> correctAnswerPair;

    @Column(length = 1000)
    @Convert(converter = MapToStringConverter.class)
    private Map<String, String> userResponse;

    @Column(length = 1000)
    @Convert(converter = MapToStringConverter.class)
    private Map<String, String> partWiseMark;

    private float totalMarks;

    @Enumerated(EnumType.STRING)
    private Result result;


    @ManyToOne
    @JoinColumn(name = "contest_id")
    private Contest contest;
}

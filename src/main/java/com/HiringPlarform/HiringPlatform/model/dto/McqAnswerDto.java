package com.HiringPlarform.HiringPlatform.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class McqAnswerDto {

    private String questionId;
    private String chosenAnswer;
}

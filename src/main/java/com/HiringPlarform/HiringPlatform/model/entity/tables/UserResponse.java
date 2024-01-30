package com.HiringPlarform.HiringPlatform.model.entity.tables;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String questionId;
    private String chosenAnswer;
    private String isCorrect;
}

package com.HiringPlarform.HiringPlatform.model.entity.tables;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SavedMcq {

    private String questionId;
    private String userResponse;
    private String CorrectAnswer;
}

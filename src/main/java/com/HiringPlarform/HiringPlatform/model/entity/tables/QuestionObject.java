package com.HiringPlarform.HiringPlatform.model.entity.tables;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class QuestionObject {

    private String qid;
    private String percentage;
    private String language;
    private List<CasesObject> testcase;
    private String code;

}
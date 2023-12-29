package com.HiringPlarform.HiringPlatform.model.entity.tables;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class questionObject {

    private String qid;
    private String question;
    private String percentage;
    private String language;
    private List<casesObject> testcase;
    private String code;

}
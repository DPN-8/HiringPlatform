package com.HiringPlarform.HiringPlatform.model.dto;


import com.HiringPlarform.HiringPlatform.model.entity.tables.CasesObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeSubmissionDto {

    private String questionId;
    private String input;
    private String code;
    private String language;

}

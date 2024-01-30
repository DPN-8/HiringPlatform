package com.HiringPlarform.HiringPlatform.model.entity.tables;


import lombok.*;


@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CasesObject {

    private String testcase_id;
    private String input;
    private String output;
    private String user_output;
}
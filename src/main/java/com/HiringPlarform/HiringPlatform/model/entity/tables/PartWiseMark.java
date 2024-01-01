package com.HiringPlarform.HiringPlatform.model.entity.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartWiseMark {

    private String part;
    private int mark;
}

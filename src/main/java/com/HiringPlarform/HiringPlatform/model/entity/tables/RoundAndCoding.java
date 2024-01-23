package com.HiringPlarform.HiringPlatform.model.entity.tables;


import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class RoundAndCoding implements Serializable {

    @ManyToOne
    private Rounds rounds;

    @ManyToOne
    private CodingQuestion codingQuestion;
}

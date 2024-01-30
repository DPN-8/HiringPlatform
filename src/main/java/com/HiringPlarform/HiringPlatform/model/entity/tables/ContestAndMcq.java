package com.HiringPlarform.HiringPlatform.model.entity.tables;


import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ContestAndMcq implements Serializable {

    @ManyToOne
    private Contest contest;

    @ManyToOne
    private MultipleChoiceQuestion multipleChoiceQuestion;
}

package com.HiringPlarform.HiringPlatform.model.entity.tables;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "round_and_mcq_question")
public class RoundAndMcqQuestion {

    @EmbeddedId
    private RoundAndMCQ roundAndMCQ;

}

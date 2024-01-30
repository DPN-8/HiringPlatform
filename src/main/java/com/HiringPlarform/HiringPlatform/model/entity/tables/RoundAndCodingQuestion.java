package com.HiringPlarform.HiringPlatform.model.entity.tables;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class RoundAndCodingQuestion {

    @EmbeddedId
    private ContestAndCoding roundAndCoding;

    @ManyToOne
    private Rounds rounds;

}

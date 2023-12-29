package com.HiringPlarform.HiringPlatform.model.entity.tables;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="codingResult")
public class CodingResult {

    @Id
    private String result_id;
    private String userId;
    private String contest_id;
    private double total_percentage;
    private List<questionObject> questions;

}
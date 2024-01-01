package com.HiringPlarform.HiringPlatform.model.entity.tables;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "mcqResult")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MCQResult {

    @Id
    private String mcqResultId;

    private String contestId;
    private String userId;
    private List<SavedMcq> savedMcq;
    private List<PartWiseMark> partWiseMarks;
    private int totalMarks;

}

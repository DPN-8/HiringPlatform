package com.HiringPlarform.HiringPlatform.model.entity.tables;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_educational_details")
public class Resume {

    @Id
    @OneToOne
    private User user;

    private String department;
    private String resumeUrl;
    private int yearOfGraduation;
}

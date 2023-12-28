package com.HiringPlarform.HiringPlatform.model.entity.tables;


import com.HiringPlarform.HiringPlatform.model.enums.AOI;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_table")
public class Employee {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private AOI areaOfInterest;

    @OneToOne
    @JoinColumn(name = "userId")
    private User userId;



}

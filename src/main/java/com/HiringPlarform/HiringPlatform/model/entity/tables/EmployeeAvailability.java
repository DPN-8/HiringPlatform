package com.HiringPlarform.HiringPlatform.model.entity.tables;


import com.HiringPlarform.HiringPlatform.model.entity.enums.EmployeeResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employee_availability_table")
@Entity
public class EmployeeAvailability{

    @EmbeddedId
    private EmployeeAndContest employeeAndContest;

    @Enumerated(EnumType.STRING)
    private EmployeeResponse response;
}

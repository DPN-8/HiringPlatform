package com.HiringPlarform.HiringPlatform.repository;

import com.HiringPlarform.HiringPlatform.model.entity.enums.EmployeeResponse;
import com.HiringPlarform.HiringPlatform.model.entity.tables.Employee;
import com.HiringPlarform.HiringPlatform.model.entity.tables.EmployeeAndContest;
import com.HiringPlarform.HiringPlatform.model.entity.tables.EmployeeAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeAvailabilityRepository extends JpaRepository<EmployeeAvailability, Long> {
    List<EmployeeAvailability> findByResponse(EmployeeResponse response);
}

package com.HiringPlarform.HiringPlatform.repository;

import com.HiringPlarform.HiringPlatform.model.entity.tables.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, String> {
}

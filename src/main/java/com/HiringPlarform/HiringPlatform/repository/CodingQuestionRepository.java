package com.HiringPlarform.HiringPlatform.repository;


import com.HiringPlarform.HiringPlatform.model.entity.tables.CodingQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodingQuestionRepository extends JpaRepository<CodingQuestion, Long> {

}

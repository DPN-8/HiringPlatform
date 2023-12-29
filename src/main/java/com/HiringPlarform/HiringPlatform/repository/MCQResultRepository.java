package com.HiringPlarform.HiringPlatform.repository;

import com.HiringPlarform.HiringPlatform.model.entity.tables.MultipleChoiceQuestionResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MCQResultRepository extends JpaRepository<MultipleChoiceQuestionResult, String> {

}

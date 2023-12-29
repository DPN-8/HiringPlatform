package com.HiringPlarform.HiringPlatform.repository;

import com.HiringPlarform.HiringPlatform.model.entity.tables.MultipleChoiceQuestionResult;
import com.HiringPlarform.HiringPlatform.model.entity.tables.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MCQRepository extends JpaRepository<MultipleChoiceQuestionResult, String> {

}

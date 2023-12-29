package com.HiringPlarform.HiringPlatform.repository;

import com.HiringPlarform.HiringPlatform.model.entity.tables.MultipleChoiceQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MCQQuestion extends JpaRepository<MultipleChoiceQuestion, String> {
}

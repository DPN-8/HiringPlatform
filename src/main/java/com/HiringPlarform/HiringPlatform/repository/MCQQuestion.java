package com.HiringPlarform.HiringPlatform.repository;

import com.HiringPlarform.HiringPlatform.model.entity.enums.Difficulty;
import com.HiringPlarform.HiringPlatform.model.entity.tables.Category;
import com.HiringPlarform.HiringPlatform.model.entity.tables.MultipleChoiceQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MCQQuestion extends JpaRepository<MultipleChoiceQuestion, String> {


    @Query("SELECT q FROM MultipleChoiceQuestion q WHERE q.category.categoryId = ?1 AND q.difficulty = ?2 ORDER BY RANDOM() LIMIT ?3")
    List<MultipleChoiceQuestion> getRandomQuestion(int id, Difficulty difficulty, int easy);
}

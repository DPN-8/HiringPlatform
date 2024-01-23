package com.HiringPlarform.HiringPlatform.repository;

import com.HiringPlarform.HiringPlatform.model.entity.tables.MultipleChoiceQuestion;
import com.HiringPlarform.HiringPlatform.model.entity.tables.RoundAndMCQ;
import com.HiringPlarform.HiringPlatform.model.entity.tables.RoundAndMcqQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoundsAndQuestionRepository extends JpaRepository<RoundAndMcqQuestion, RoundAndMCQ> {

    @Query(value = "SELECT q.roundAndMCQ.multipleChoiceQuestion FROM RoundAndMcqQuestion q WHERE q.roundAndMCQ.rounds.roundsId =?1")
    List<MultipleChoiceQuestion> getRandomQuestions(String id);
}

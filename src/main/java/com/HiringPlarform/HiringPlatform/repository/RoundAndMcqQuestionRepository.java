package com.HiringPlarform.HiringPlatform.repository;

import com.HiringPlarform.HiringPlatform.model.entity.tables.MultipleChoiceQuestion;
import com.HiringPlarform.HiringPlatform.model.entity.tables.RoundAndMcqQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoundAndMcqQuestionRepository extends JpaRepository<RoundAndMcqQuestion, Long> {

    @Query(value = "SELECT q.contestAndMcq.multipleChoiceQuestion FROM RoundAndMcqQuestion q WHERE q.rounds.roundsId =?1")
    List<MultipleChoiceQuestion> findByRoundId(String roundsId);
}

package com.HiringPlarform.HiringPlatform.repository;

import com.HiringPlarform.HiringPlatform.model.entity.tables.EmailTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmailTaskRepository extends JpaRepository<EmailTask, Long> {


    List<EmailTask> findEmailTasksByTaskTimeAfterAndTaskTimeBefore(LocalDateTime startTime, LocalDateTime endTime);
}

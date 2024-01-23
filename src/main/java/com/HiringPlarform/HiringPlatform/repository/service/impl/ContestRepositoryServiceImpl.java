package com.HiringPlarform.HiringPlatform.repository.service.impl;

import com.HiringPlarform.HiringPlatform.converters.RandomStringGenerator;
import com.HiringPlarform.HiringPlatform.model.dto.ContestDto;
import com.HiringPlarform.HiringPlatform.model.dto.ResponseDto;
import com.HiringPlarform.HiringPlatform.model.entity.tables.Contest;
import com.HiringPlarform.HiringPlatform.repository.ContestRepository;
import com.HiringPlarform.HiringPlatform.repository.service.ContestRepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
@Slf4j
public class ContestRepositoryServiceImpl implements ContestRepositoryService {

    private final ContestRepository contestRepository;

    public ContestRepositoryServiceImpl(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    @Override
    public Contest findContestByContestId(String contestId) {
        return contestRepository.findContestByContestId(contestId);
    }

    @Override
    public void save(Contest contest) {
        contestRepository.save(contest);
    }
}

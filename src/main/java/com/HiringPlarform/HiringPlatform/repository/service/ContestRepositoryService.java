package com.HiringPlarform.HiringPlatform.repository.service;

import com.HiringPlarform.HiringPlatform.api.ContestApi;
import com.HiringPlarform.HiringPlatform.model.dto.ContestDto;
import com.HiringPlarform.HiringPlatform.model.dto.ResponseDto;
import com.HiringPlarform.HiringPlatform.model.entity.tables.Contest;
import com.HiringPlarform.HiringPlatform.repository.ContestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ContestRepositoryService {

    Contest findContestByContestId(String contestId);
    void save(Contest contest);
}

package com.HiringPlarform.HiringPlatform.controller;

import com.HiringPlarform.HiringPlatform.api.ContestApi;
import com.HiringPlarform.HiringPlatform.model.dto.ContestDto;
import com.HiringPlarform.HiringPlatform.model.dto.ResponseDto;
import com.HiringPlarform.HiringPlatform.model.entity.tables.Contest;
import com.HiringPlarform.HiringPlatform.service.ContestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ContestController implements ContestApi {

    private final ContestService contestService;

    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @Override
    public ResponseEntity<ResponseDto> createContest(ContestDto contest) {
        return contestService.createContest(contest);
    }

    @Override
    public ResponseEntity<ResponseDto> updateContest(Contest contest, String contestId) {
        log.info(contestId);
        return contestService.updateContest(contest, contestId);
    }

    @Override
    public ResponseEntity<ResponseDto> getAllContest() {
        return contestService.getAllContestDetails();
    }

    @Override
    public ResponseEntity<ResponseDto> getContest(String contestId) {
        return contestService.getContest(contestId);
    }
}

package com.HiringPlarform.HiringPlatform.service;

import com.HiringPlarform.HiringPlatform.model.dto.ContestDto;
import com.HiringPlarform.HiringPlatform.model.dto.ResponseDto;
import com.HiringPlarform.HiringPlatform.model.entity.tables.Contest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ContestService {


    ResponseEntity<ResponseDto> createContest(ContestDto contest);

    ResponseEntity<ResponseDto> updateContest(Contest contest, String contestId);

    ResponseEntity<ResponseDto> getContest(String contestId);

    ResponseEntity<ResponseDto> getAllContestDetails();
}

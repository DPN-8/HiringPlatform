package com.HiringPlarform.HiringPlatform.api;


import com.HiringPlarform.HiringPlatform.model.dto.ContestDto;
import com.HiringPlarform.HiringPlatform.model.dto.ResponseDto;
import com.HiringPlarform.HiringPlatform.model.entity.tables.Contest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contest")
public interface ContestApi {
    @PostMapping
    ResponseEntity<ResponseDto> createContest(@RequestBody ContestDto contest);
    @PatchMapping("/contest-id/{contestId}")
    ResponseEntity<ResponseDto> updateContest(@RequestBody Contest contest, @PathVariable String contestId);
    @GetMapping
    ResponseEntity<ResponseDto> getAllContest();
    @GetMapping("/contest-id/{contestId}")
    ResponseEntity<ResponseDto> getContest(@PathVariable String contestId);
}

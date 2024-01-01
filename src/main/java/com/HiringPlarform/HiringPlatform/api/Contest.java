package com.HiringPlarform.HiringPlatform.api;


import com.HiringPlarform.HiringPlatform.model.dto.LoginDto;
import com.HiringPlarform.HiringPlatform.model.dto.McqAnswerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1/contest/")
public interface Contest {

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody LoginDto loginDto);
    @GetMapping("/user/{userId}")
    ResponseEntity<?> contest(@PathVariable String userId);
    @GetMapping("/mcq/{contestId}")
    ResponseEntity<?> mcqPart(@PathVariable String contestId);
    @PostMapping("/mcq/{contestId}/{partId}")
    ResponseEntity<?> mcqQuestion(@PathVariable String contestId, @PathVariable String partId, @RequestBody List<McqAnswerDto> mcqAnswerDto);
    @GetMapping("/coding/{contestId}")
    ResponseEntity<?> codePart(@PathVariable String contestId);


}

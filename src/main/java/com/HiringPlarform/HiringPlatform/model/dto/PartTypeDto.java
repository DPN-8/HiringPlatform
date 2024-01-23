package com.HiringPlarform.HiringPlatform.model.dto;


import com.HiringPlarform.HiringPlatform.model.entity.enums.RoundType;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PartTypeDto {

    private RoundType roundType;

    private List<PartDto> parts;

    @Future(message = "Start time must be in the future")
    private LocalDateTime startTime;

    @Future(message = "End time must be in the future")
    private LocalDateTime endTime;

}

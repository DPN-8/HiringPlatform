package com.HiringPlarform.HiringPlatform.model.entity.tables;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartWiseResponse {

    private String category;
    private List<UserResponse> userResponse;
}

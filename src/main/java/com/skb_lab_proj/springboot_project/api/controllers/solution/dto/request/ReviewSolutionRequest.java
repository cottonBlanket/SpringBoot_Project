package com.skb_lab_proj.springboot_project.api.controllers.solution.dto.request;

import com.skb_lab_proj.springboot_project.dal.solution.enums.Status;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class ReviewSolutionRequest {
    Long id;
    Status status;
    int scores;
}

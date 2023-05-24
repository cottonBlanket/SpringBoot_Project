package com.skb_lab_proj.springboot_project.api.controllers.solution.dto.request;

import com.skb_lab_proj.springboot_project.dal.solution.enums.Status;
import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Value
@Getter
public class ReviewSolutionRequest {
    Long id;
    Status status;
    @Min(0)
    @Max(5)
    Integer scores;
}

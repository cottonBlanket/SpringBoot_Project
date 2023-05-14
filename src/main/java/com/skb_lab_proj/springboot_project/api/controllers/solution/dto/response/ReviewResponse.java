package com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response;

import com.skb_lab_proj.springboot_project.dal.solution.enums.Status;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReviewResponse {

    Long id;
    Status status;
    int scores;
}

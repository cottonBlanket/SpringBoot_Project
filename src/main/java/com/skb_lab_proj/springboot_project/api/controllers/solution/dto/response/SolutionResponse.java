package com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response;

import com.skb_lab_proj.springboot_project.dal.solution.enums.Status;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@Value
@Builder
@FieldDefaults(level = AccessLevel.PUBLIC)
public class SolutionResponse {
    Long id;
    String link;
    Status status;
    int scores;
    String studentName;
}

package com.skb_lab_proj.springboot_project.api.controllers.solution.dto.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateSolutionRequest {
    Long id;
    String link;
}

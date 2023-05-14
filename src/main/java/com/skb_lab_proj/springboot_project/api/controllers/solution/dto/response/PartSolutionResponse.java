package com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@Value
@Builder
@FieldDefaults(level = AccessLevel.PUBLIC)
public class PartSolutionResponse {

    Long id;
    String link;
}

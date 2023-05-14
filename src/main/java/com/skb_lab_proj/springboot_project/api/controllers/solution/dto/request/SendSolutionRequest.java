package com.skb_lab_proj.springboot_project.api.controllers.solution.dto.request;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class SendSolutionRequest {
    String link;
    Long taskId;
}

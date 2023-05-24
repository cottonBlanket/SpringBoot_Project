package com.skb_lab_proj.springboot_project.api.controllers.solution.dto.request;

import com.skb_lab_proj.springboot_project.api.validation.annotation.LinkConstraint;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class SendSolutionRequest {
    @LinkConstraint
    String link;
    Long taskId;
}

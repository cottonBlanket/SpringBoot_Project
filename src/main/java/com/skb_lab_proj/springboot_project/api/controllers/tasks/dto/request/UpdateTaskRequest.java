package com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateTaskRequest {

    Long id;
    String name;
    String text;
}

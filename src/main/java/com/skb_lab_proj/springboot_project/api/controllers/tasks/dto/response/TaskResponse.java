package com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TaskResponse {

    public Long id;

    public String name;
    public String text;

    public Long lessonId;
}

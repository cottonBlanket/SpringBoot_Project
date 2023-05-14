package com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.request;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class CreateTaskRequest {

    String name;
    String text;
    Long lessonId;
}

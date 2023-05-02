package com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateLessonRequest {

    String name;
}

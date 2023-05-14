package com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LessonInfoResponse {

    Long id;

    String name;
}

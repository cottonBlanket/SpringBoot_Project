package com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class UpdateLessonRequest {

    Long id;

    String name;
}

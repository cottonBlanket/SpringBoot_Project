package com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response;

import com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.response.TaskResponse;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class LessonResponse {

    public Long id;

    public String name;

    public List<TaskResponse> tasks;
}

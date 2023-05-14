package com.skb_lab_proj.springboot_project.logic.managers;

import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.request.CreateLessonRequest;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.request.UpdateLessonRequest;
import com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.request.CreateTaskRequest;
import com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.request.UpdateTaskRequest;
import com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.response.TaskResponse;

public interface TaskService {

    TaskResponse create(CreateTaskRequest request);
    TaskResponse get(Long id);
    TaskResponse update(UpdateTaskRequest request);
    void delete(Long id);

}

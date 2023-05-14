package com.skb_lab_proj.springboot_project.api.controllers.tasks;

import com.skb_lab_proj.springboot_project.api.annotation.TaskApiV1;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.request.CreateLessonRequest;
import com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.request.CreateTaskRequest;
import com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.request.UpdateTaskRequest;
import com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.response.TaskResponse;
import com.skb_lab_proj.springboot_project.logic.managers.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;

@TaskApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TaskController {

    TaskService taskService;

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable Long taskId) {
        return new ResponseEntity<>(taskService.get(taskId), HttpStatus.OK);
    }
}

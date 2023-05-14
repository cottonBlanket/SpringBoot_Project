package com.skb_lab_proj.springboot_project.api.controllers.tasks;

import com.skb_lab_proj.springboot_project.api.annotation.AdminApiV1;
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

@AdminApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TaskAdminController {

    TaskService taskService;

    @PostMapping("task/create")
    public ResponseEntity<TaskResponse> createTask(@RequestBody CreateTaskRequest request) {
        return new ResponseEntity<>(taskService.create(request), HttpStatus.OK);

    }

    @PutMapping("task/edit")
    public ResponseEntity<TaskResponse> updateTask(@RequestBody UpdateTaskRequest request) {
        return new ResponseEntity<>(taskService.update(request), HttpStatus.OK);
    }

    @DeleteMapping("task/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.delete(taskId);
    }
}

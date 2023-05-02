package com.skb_lab_proj.springboot_project.logic.managers.factory;

import com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.response.TaskResponse;
import com.skb_lab_proj.springboot_project.dal.task.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskFactory {

    public TaskResponse createTaskResponseFrom(Task task) {
        return TaskResponse
                .builder()
                .id(task.getId())
                .name(task.getName())
                .text(task.getText())
                .build();
    }
}

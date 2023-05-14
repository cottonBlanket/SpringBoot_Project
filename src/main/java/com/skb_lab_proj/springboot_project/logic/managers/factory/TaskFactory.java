package com.skb_lab_proj.springboot_project.logic.managers.factory;

import com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.request.CreateTaskRequest;
import com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.request.UpdateTaskRequest;
import com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.response.TaskResponse;
import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
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
                .lessonId(task.getLesson().getId())
                .build();
    }

    public Task createTaskFrom(CreateTaskRequest request, Lesson lesson) {
        return Task
                .builder()
                .name(request.getName())
                .text(request.getText())
                .lesson(lesson)
                .build();
    }

    public void updateTask(Task task, UpdateTaskRequest request) {
        task.setName(request.getName());
        task.setText(request.getText());
    }
}

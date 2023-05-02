package com.skb_lab_proj.springboot_project.logic.managers.factory;

import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.CreateLessonResponse;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.LessonResponse;
import com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.response.TaskResponse;
import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.dal.task.Task;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class LessonFactory {

    TaskFactory taskFactory;
    public CreateLessonResponse createResponseFrom(Lesson lesson) {
        return CreateLessonResponse
                .builder()
                .id(lesson.getId())
                .name(lesson.getName())
                .build();
    }

    public LessonResponse createLessonResponseFrom(Lesson lesson) {
        return LessonResponse
                .builder()
                .id(lesson.getId())
                .name(lesson.getName())
                .tasks(lesson
                        .getTasks()
                        .stream()
                        .map(task -> taskFactory.createTaskResponseFrom(task))
                        .collect(Collectors.toList()))
                .build();
    }
}

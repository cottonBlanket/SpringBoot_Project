package com.skb_lab_proj.springboot_project.logic.managers.impl;

import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.request.UpdateLessonRequest;
import com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.request.CreateTaskRequest;
import com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.request.UpdateTaskRequest;
import com.skb_lab_proj.springboot_project.api.controllers.tasks.dto.response.TaskResponse;
import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.dal.lesson.repositories.LessonRepository;
import com.skb_lab_proj.springboot_project.dal.task.Task;
import com.skb_lab_proj.springboot_project.dal.task.repositories.TaskRepository;
import com.skb_lab_proj.springboot_project.logic.managers.TaskService;
import com.skb_lab_proj.springboot_project.logic.managers.factory.TaskFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;
    LessonRepository lessonRepository;
    TaskFactory taskFactory;
    @Override
    public TaskResponse create(CreateTaskRequest request) {
        Lesson lesson = lessonRepository.findById(request.getLessonId()).orElseThrow();
        Task task = taskFactory.createTaskFrom(request, lesson);
        task = taskRepository.save(task);
        return taskFactory.createTaskResponseFrom(task);
    }

    @Override
    public TaskResponse get(Long id) {
        Task task = taskRepository.getReferenceById(id);
        return taskFactory.createTaskResponseFrom(task);
    }

    @Override
    public TaskResponse update(UpdateTaskRequest request) {
        Task task = taskRepository.getReferenceById(request.getId());
        taskFactory.updateTask(task, request);
        return taskFactory.createTaskResponseFrom(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}

package com.skb_lab_proj.springboot_project.logic.managers;

import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.CreateLessonResponseModel;
import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.logic.managers.BaseService;

import java.util.List;

public interface LessonService extends BaseService<Lesson> {
    List<CreateLessonResponseModel> getAll();

    CreateLessonResponseModel getLesson(Long id);
}

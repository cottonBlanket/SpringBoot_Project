package com.skb_lab_proj.springboot_project.logic.managers;

import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.logic.managers.BaseService;

import java.util.List;

public interface LessonService extends BaseService<Lesson> {
    List<Lesson> getAll();
}

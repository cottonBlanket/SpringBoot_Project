package com.skb_lab_proj.springboot_project.logic.managers.Lesson;

import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;

public interface LessonService {
    public void createLesson(Lesson lesson);

    public Lesson update(Long id);
}

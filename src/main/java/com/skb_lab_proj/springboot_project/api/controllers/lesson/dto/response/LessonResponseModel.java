package com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response;

import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import lombok.Value;

@Value
public class LessonResponseModel {
    public String name;

    public LessonResponseModel(Lesson lesson){
        name = lesson.getName();
    }
}

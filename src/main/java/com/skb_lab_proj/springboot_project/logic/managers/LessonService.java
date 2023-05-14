package com.skb_lab_proj.springboot_project.logic.managers;

import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.request.CreateLessonRequest;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.request.UpdateLessonRequest;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.CreateLessonResponse;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.LessonInfoResponse;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.LessonResponse;

import java.util.List;

public interface LessonService {

    CreateLessonResponse create(String name);

    LessonResponse get(Long id);

    LessonInfoResponse update(UpdateLessonRequest request);

    void delete(Long id);

    List<LessonInfoResponse> getAll();

}

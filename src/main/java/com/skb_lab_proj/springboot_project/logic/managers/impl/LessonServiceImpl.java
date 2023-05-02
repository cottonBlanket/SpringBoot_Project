package com.skb_lab_proj.springboot_project.logic.managers.impl;

import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.request.CreateLessonRequest;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.CreateLessonResponse;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.LessonResponse;
import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.dal.lesson.repositories.LessonRepository;
import com.skb_lab_proj.springboot_project.logic.managers.LessonService;
import com.skb_lab_proj.springboot_project.logic.managers.factory.LessonFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LessonServiceImpl implements LessonService {
    LessonRepository lessonRepository;
    LessonFactory lessonFactory;

    @Override
    public CreateLessonResponse create(CreateLessonRequest request) {
        Lesson lesson = Lesson.builder().name(request.getName()).build();
        lesson = lessonRepository.save(lesson);
        return lessonFactory.createResponseFrom(lesson);
    }

    @Override
    public LessonResponse get(Long id) {
        Lesson lesson = lessonRepository.getReferenceById(id);
        return lessonFactory.createLessonResponseFrom(lesson);
    }
}

package com.skb_lab_proj.springboot_project.logic.managers.impl;

import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.CreateLessonResponseModel;
import com.skb_lab_proj.springboot_project.api.controllers.user.dto.response.CreateUserResponseModel;
import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.dal.lesson.repositories.LessonRepository;
import com.skb_lab_proj.springboot_project.logic.managers.LessonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LessonServiceImpl implements LessonService {
    LessonRepository lessonRepository;
    @Override
    public Lesson create(Lesson dal) {
        return lessonRepository.save(dal);
    }

    @Override
    public Lesson get(Long id) {
        return null;
    }

    @Override
    @Transactional
    public CreateLessonResponseModel getLesson(Long id) {
        return lessonRepository.findById(id).stream().map(CreateLessonResponseModel::new).findFirst().orElseThrow();
    }

    @Override
    public void update(Lesson dal) {

        lessonRepository.save(dal);
    }

    @Override
    public void delete(Long id) {

        lessonRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<CreateLessonResponseModel> getAll() {
        return lessonRepository.findAll().stream().map(CreateLessonResponseModel::new).collect(Collectors.toList());
    }
}

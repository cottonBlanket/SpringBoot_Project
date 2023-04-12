package com.skb_lab_proj.springboot_project.logic.managers.impl;

import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.dal.lesson.repositories.LessonRepository;
import com.skb_lab_proj.springboot_project.logic.managers.LessonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional
    public Lesson get(Long id) {
        return lessonRepository.findById(id).orElseThrow();
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
    public List<Lesson> getAll() {
        return lessonRepository.findAll();
    }
}

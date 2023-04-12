package com.skb_lab_proj.springboot_project.logic.managers.Lesson.impl;

import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.dal.lesson.repositories.LessonRepository;
import com.skb_lab_proj.springboot_project.logic.managers.Lesson.LessonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LessonServiceImpl implements LessonService {

    LessonRepository lessonRepository;

    @Override
    public void createLesson(Lesson lesson) {
        var l = lessonRepository.save(lesson);
    }

    @Override
    public Lesson update(Long id) {
        var l = lessonRepository.findById(id);
        if(l != null){
            
        }
    }


}

package com.skb_lab_proj.springboot_project.dal.lesson.repositories;

import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}

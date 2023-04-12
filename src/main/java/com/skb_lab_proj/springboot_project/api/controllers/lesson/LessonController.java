package com.skb_lab_proj.springboot_project.api.controllers.lesson;

import com.skb_lab_proj.springboot_project.api.annotation.LessonApiV1;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.request.UpdateLessonModelRequest;
import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.logic.managers.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static lombok.AccessLevel.PRIVATE;

@LessonApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class LessonController {
    LessonService lessonService;

    @PostMapping("/createLesson/{name}")
    public ResponseEntity<Lesson> createLesson(
            @PathVariable String name){
        var lesson = Lesson.builder()
                .name(name)
                .build();
        var a = lessonService.create(lesson);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @GetMapping("/get/lesson/{id}")
    public ResponseEntity<Lesson> getLesson(@PathVariable Long id) {
        var a = lessonService.get(id);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @PostMapping("/updateLesson/{name}")
    public ResponseEntity<Lesson> updateLesson(
            @PathVariable String name){
        Lesson lesson = Lesson.builder()
                .name(name)
                .build();
        lessonService.update(lesson);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete/lesson={id}")
    public ResponseEntity<Lesson> delete(@PathVariable Long id){
        lessonService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Lesson>> getAll(){
        return new ResponseEntity<>(lessonService.getAll(), HttpStatus.OK);
    }
}

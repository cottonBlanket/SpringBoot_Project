package com.skb_lab_proj.springboot_project.api.controllers.lesson;

import com.skb_lab_proj.springboot_project.api.annotation.LessonApiV1;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.request.CreateLessonRequest;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.request.UpdateLessonModelRequest;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.CreateLessonResponse;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.CreateLessonResponseModel;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.LessonResponse;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.LessonResponseModel;
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

    @PostMapping("/create")
    public ResponseEntity<CreateLessonResponse> createLesson(@ResponseBody CreateLessonRequest request){
        return new ResponseEntity<>(lessonService.create(request), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonResponse> getLesson(@PathVariable Long id) {
        return new ResponseEntity<>(lessonService.get(id), HttpStatus.OK);
    }

    @PostMapping("/{lessonId:Long}")
    public ResponseEntity<Lesson> updateLesson(
            @PathVariable Long lessonId){
        Lesson lesson = Lesson.builder()
                .name(lessonId.toString())
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
    public ResponseEntity<List<LessonResponseModel>> getAll(){
        return new ResponseEntity<>(lessonService.getAll(), HttpStatus.OK);
    }
}

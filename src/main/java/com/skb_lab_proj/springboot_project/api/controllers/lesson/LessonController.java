package com.skb_lab_proj.springboot_project.api.controllers.lesson;

import com.skb_lab_proj.springboot_project.api.annotation.LessonApiV1;
import com.skb_lab_proj.springboot_project.api.annotation.UserApiV1;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.request.CreateLessonModelRequest;
import com.skb_lab_proj.springboot_project.api.controllers.user.dto.request.CreateUserRequestModel;
import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.dal.user.User;
import com.skb_lab_proj.springboot_project.logic.managers.Lesson.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static lombok.AccessLevel.PRIVATE;

@LessonApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class LessonController {

    LessonService lessonService;

    @PostMapping("/createlesson")
    public ResponseEntity<Lesson> createLesson(@RequestBody CreateLessonModelRequest model){
        var l = Lesson.builder()
                .name(model.name)
                .build();
        lessonService.createLesson(l);
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Lesson> update(@RequestBody CreateLessonModelRequest model){
        var l = Lesson.builder()
                .name(model.name)
                .build();
        lessonService.update(l);
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

}

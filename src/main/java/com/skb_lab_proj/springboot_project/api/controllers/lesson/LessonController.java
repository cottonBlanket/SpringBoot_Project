package com.skb_lab_proj.springboot_project.api.controllers.lesson;

import com.skb_lab_proj.springboot_project.api.annotation.api.ControllerApi;
import com.skb_lab_proj.springboot_project.api.annotation.api.LessonApiV1;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.LessonInfoResponse;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.LessonResponse;
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

    @GetMapping("/{id}")
    public ResponseEntity<LessonResponse> getLesson(@PathVariable Long id) {
        return new ResponseEntity<>(lessonService.get(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LessonInfoResponse>> getAll(){
        return new ResponseEntity<>(lessonService.getAll(), HttpStatus.OK);
    }
}

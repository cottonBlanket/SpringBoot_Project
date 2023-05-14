package com.skb_lab_proj.springboot_project.api.controllers.lesson;

import com.skb_lab_proj.springboot_project.api.annotation.AdminApiV1;
import com.skb_lab_proj.springboot_project.api.annotation.LessonApiV1;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.request.UpdateLessonRequest;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.CreateLessonResponse;
import com.skb_lab_proj.springboot_project.api.controllers.lesson.dto.response.LessonInfoResponse;
import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.logic.managers.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;

@AdminApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class LessonAdminController {

    LessonService lessonService;

    @PostMapping("/lesson/create")
    public ResponseEntity<CreateLessonResponse> createLesson(@RequestParam String name, Authentication auth){
        return new ResponseEntity<>(lessonService.create(name), HttpStatus.OK);
    }

    @PutMapping("/lesson/update")
    public ResponseEntity<LessonInfoResponse> updateLesson(@RequestBody UpdateLessonRequest request){
        return new ResponseEntity<>(lessonService.update(request), HttpStatus.OK);
    }

    @DeleteMapping("/lesson/{lessonId}")
    public ResponseEntity<Lesson> delete(@PathVariable Long lessonId){
        lessonService.delete(lessonId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

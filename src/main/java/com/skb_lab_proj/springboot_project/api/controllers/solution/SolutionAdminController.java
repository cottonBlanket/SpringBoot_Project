package com.skb_lab_proj.springboot_project.api.controllers.solution;

import com.skb_lab_proj.springboot_project.api.annotation.api.AdminApiV1;
import com.skb_lab_proj.springboot_project.api.annotation.api.ControllerApi;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.request.ReviewSolutionRequest;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response.ReviewResponse;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response.SolutionResponse;
import com.skb_lab_proj.springboot_project.dal.solution.enums.Status;
import com.skb_lab_proj.springboot_project.logic.managers.SolutionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@AdminApiV1
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SolutionAdminController {

    SolutionService solutionService;

    @PatchMapping("solution/review")
    public ResponseEntity<ReviewResponse> reviewSolution(@RequestBody ReviewSolutionRequest request, Authentication auth) {
        return new ResponseEntity<>(solutionService.reviewSolution(request, auth.getName()), HttpStatus.OK);
    }

    @GetMapping("solution/all")
    public ResponseEntity<List<SolutionResponse>> getAllSolutionByTask(@RequestParam(required = false) Long task,
                                                                       @RequestParam(required = false) String role,
                                                                       @RequestParam(required = false) Integer room,
                                                                       @RequestParam(required = false) Status status) {
        return new ResponseEntity<>(solutionService.getAllSolutionWithFilters(task, role, room, status), HttpStatus.OK);
    }
}

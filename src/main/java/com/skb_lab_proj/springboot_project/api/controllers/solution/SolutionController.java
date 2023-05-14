package com.skb_lab_proj.springboot_project.api.controllers.solution;

import com.skb_lab_proj.springboot_project.api.annotation.SolutionApiV1;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.request.SendSolutionRequest;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.request.UpdateSolutionRequest;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response.PartSolutionResponse;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response.SolutionResponse;
import com.skb_lab_proj.springboot_project.logic.managers.SolutionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@SolutionApiV1
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SolutionController {

    SolutionService solutionService;

    @PostMapping("/send")
    public ResponseEntity<PartSolutionResponse> sendSolution(@RequestBody SendSolutionRequest request, Authentication auth) {
        return new ResponseEntity<>(solutionService.createSolution(request, auth.getName()), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<PartSolutionResponse> updateSolution(@RequestBody UpdateSolutionRequest request, Authentication auth) {
        return new ResponseEntity<>(solutionService.updateSolution(request, auth.getName()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolutionResponse> getSolution(@PathVariable Long id, Authentication auth) {
        return new ResponseEntity<>(solutionService.getSolution(id, auth.getName()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteSolution(@PathVariable Long id, Authentication auth) {
        solutionService.deleteSolution(id, auth.getName());
    }
}

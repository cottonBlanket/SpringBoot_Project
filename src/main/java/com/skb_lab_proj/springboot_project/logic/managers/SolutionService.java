package com.skb_lab_proj.springboot_project.logic.managers;

import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.request.ReviewSolutionRequest;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.request.SendSolutionRequest;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.request.UpdateSolutionRequest;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response.PartSolutionResponse;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response.ReviewResponse;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response.SolutionResponse;
import com.skb_lab_proj.springboot_project.dal.solution.enums.Status;

import java.util.List;

public interface SolutionService {

    PartSolutionResponse createSolution(SendSolutionRequest request, String email);
    PartSolutionResponse updateSolution(UpdateSolutionRequest request, String email);
    SolutionResponse getSolution(Long id, String email);
    void deleteSolution(Long id, String email);
    ReviewResponse reviewSolution(ReviewSolutionRequest request, String email);
    List<SolutionResponse> getAllSolutionWithFilters(Long taskId, Integer room, Status status);
}

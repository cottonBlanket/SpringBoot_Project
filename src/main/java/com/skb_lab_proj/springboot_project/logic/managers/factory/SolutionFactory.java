package com.skb_lab_proj.springboot_project.logic.managers.factory;

import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response.PartSolutionResponse;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response.ReviewResponse;
import com.skb_lab_proj.springboot_project.api.controllers.solution.dto.response.SolutionResponse;
import com.skb_lab_proj.springboot_project.dal.solution.Solution;
import com.skb_lab_proj.springboot_project.dal.solution.enums.Status;
import com.skb_lab_proj.springboot_project.dal.task.Task;
import com.skb_lab_proj.springboot_project.dal.user.Person;
import org.springframework.stereotype.Component;

@Component
public class SolutionFactory {


    public PartSolutionResponse createPartSolutionResponseFrom(Solution solution) {
        return PartSolutionResponse
                .builder()
                .id(solution.getId())
                .link(solution.getLink())
                .build();
    }

    public Solution createSolutionFrom(String link, Task task, Person student) {
        return Solution
                .builder()
                .link(link)
                .person(student)
                .task(task)
                .scores(0)
                .status(Status.OnReview)
                .build();
    }

    public SolutionResponse createSolutionResponseFrom(Solution solution) {
        return SolutionResponse
                .builder()
                .id(solution.getId())
                .link(solution.getLink())
                .scores(solution.getScores())
                .status(solution.getStatus())
                .studentName(solution.getPerson().getSurname() + ' ' + solution.getPerson().getName())
                .build();
    }

    public ReviewResponse createReviewResponseFrom(Solution solution) {
        return ReviewResponse
                .builder()
                .id(solution.getId())
                .scores(solution.getScores())
                .status(solution.getStatus())
                .build();
    }


}

package com.skb_lab_proj.springboot_project.logic.events;

import com.skb_lab_proj.springboot_project.dal.solution.Solution;
import lombok.Value;

@Value
public class SolutionReviewedEvent {

    String studentName;
    String task;
    public static SolutionReviewedEvent from(Solution solution) {
        return new SolutionReviewedEvent(solution.getPerson().getFullName(), solution.getTask().getName());
    }
}

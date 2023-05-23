package com.skb_lab_proj.springboot_project.logic.events;

import com.skb_lab_proj.springboot_project.dal.solution.Solution;
import lombok.Value;

@Value
public class SolutionSentEvent {

    String studentName;
    String solutionLink;
    public static SolutionSentEvent from(Solution solution) {
        return new SolutionSentEvent(solution.getPerson().getFullName(), solution.getLink());
    }
}
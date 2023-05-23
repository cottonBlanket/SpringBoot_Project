package com.skb_lab_proj.springboot_project.logic.actuator.response;

import com.skb_lab_proj.springboot_project.dal.solution.enums.Status;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class StudentSolution {
    String lesson;
    String task;
    String link;
    Status status;
    int scores;
}

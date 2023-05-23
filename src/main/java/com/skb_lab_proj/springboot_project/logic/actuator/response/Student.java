package com.skb_lab_proj.springboot_project.logic.actuator.response;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Student {
    String name;
    String email;
    List<StudentSolution> solutions;
}

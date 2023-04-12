package com.skb_lab_proj.springboot_project.api.controllers.solution.dto.request;

import com.skb_lab_proj.springboot_project.dal.task.Task;
import com.skb_lab_proj.springboot_project.dal.user.Person;
import lombok.Value;

@Value
public class CreateSolutionRequestModel {
    public String gitLink;
    public Boolean allow;
}

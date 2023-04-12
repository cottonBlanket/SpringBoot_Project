package com.skb_lab_proj.springboot_project.api.controllers.user.dto.request;

import com.skb_lab_proj.springboot_project.dal.solution.Solution;
import lombok.Value;

import java.util.List;

@Value
public class CreateUserRequestModel {

    public String name;
    public String surname;
    public String password;
    public String role;
    public String email;

}

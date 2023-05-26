package com.skb_lab_proj.springboot_project.api.controllers.account.dto.request;

import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Value
@Getter
public class RegisterRequest {

    String name;
    String surname;
    String password;
    @Email
    String email;

}

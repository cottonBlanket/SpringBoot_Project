package com.skb_lab_proj.springboot_project.api.controllers.account.dto.request;

import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;

@Value
@Getter
public class EditProfileRequest {

    Long id;

    @Max(20)
    String name;

    @Max(20)
    String surname;

    @Email
    String email;

    String password;
}

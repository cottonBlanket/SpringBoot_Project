package com.skb_lab_proj.springboot_project.api.controllers.account.dto.request;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class EditProfileRequest {

    Long id;

    String name;

    String surname;

    String email;

    String password;
}

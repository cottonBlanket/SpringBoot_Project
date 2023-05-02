package com.skb_lab_proj.springboot_project.api.controllers.account.dto.request;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class RegisterRequest {

    String name;
    String surname;
    String password;
    String role;
    String email;

}

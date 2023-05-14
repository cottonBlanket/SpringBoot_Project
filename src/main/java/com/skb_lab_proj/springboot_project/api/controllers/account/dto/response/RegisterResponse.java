package com.skb_lab_proj.springboot_project.api.controllers.account.dto.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RegisterResponse {

    public Long id;
    public String email;
    public String role;
}

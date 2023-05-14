package com.skb_lab_proj.springboot_project.api.controllers.account.dto.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ChangeUserRoleRequest {
    Long id;
    String role;
}

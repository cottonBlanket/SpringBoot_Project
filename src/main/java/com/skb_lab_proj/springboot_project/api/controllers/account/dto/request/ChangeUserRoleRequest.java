package com.skb_lab_proj.springboot_project.api.controllers.account.dto.request;

import com.skb_lab_proj.springboot_project.api.validation.annotation.RoleConstraint;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ChangeUserRoleRequest {
    Long id;
    @RoleConstraint
    String role;
}

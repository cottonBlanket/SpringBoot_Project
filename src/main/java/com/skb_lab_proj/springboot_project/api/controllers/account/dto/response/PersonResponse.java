package com.skb_lab_proj.springboot_project.api.controllers.account.dto.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PersonResponse {
    Long id;

    String name;

    String surname;

    String email;

    Integer room;
}

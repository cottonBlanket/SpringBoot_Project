package com.skb_lab_proj.springboot_project.api.dto.response;

import com.skb_lab_proj.springboot_project.logic.entities.User;
import lombok.Builder;
import lombok.Value;

@Value
public class CreateUserResponseModel {

    public int id;

    public String name;

    public CreateUserResponseModel(User user) {
        this.id = user.id;
        this.name = user.name;
    }
}

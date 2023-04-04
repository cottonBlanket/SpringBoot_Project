package com.skb_lab_proj.springboot_project.api.controllers.user.dto.response;

import com.skb_lab_proj.springboot_project.dal.user.User;
import lombok.Builder;
import lombok.Value;

@Value
public class CreateUserResponseModel {

    public long id;

    public String name;

    public CreateUserResponseModel(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}

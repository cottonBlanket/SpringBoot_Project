package com.skb_lab_proj.springboot_project.api.controllers.user.dto.response;

import com.skb_lab_proj.springboot_project.dal.user.Person;
import lombok.Value;

@Value
public class CreateUserResponseModel {

    public long id;

    public String name;

    public CreateUserResponseModel(Person person) {
        this.id = person.getId();
        this.name = person.getName();
    }
}

package com.skb_lab_proj.springboot_project.logic.managers;

import com.skb_lab_proj.springboot_project.api.controllers.user.dto.response.CreateUserResponseModel;
import com.skb_lab_proj.springboot_project.api.controllers.user.dto.response.UserResponseModel;
import com.skb_lab_proj.springboot_project.dal.user.Person;

import java.util.List;

public interface PersonService extends BaseService<Person> {
    List<UserResponseModel> getAll();

    UserResponseModel getUser(Long id);
}

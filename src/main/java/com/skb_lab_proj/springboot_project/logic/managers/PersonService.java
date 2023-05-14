package com.skb_lab_proj.springboot_project.logic.managers;

import com.skb_lab_proj.springboot_project.api.controllers.account.dto.request.ChangeUserRoleRequest;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.request.EditProfileRequest;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.request.RegisterRequest;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.response.EditProfileResponse;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.response.RegisterResponse;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.response.PersonResponse;

import java.util.List;

public interface PersonService {

    RegisterResponse register(RegisterRequest request);

    EditProfileResponse update(EditProfileRequest request, String email);
    List<PersonResponse> getAll(Integer room);

    PersonResponse getUser(Long id, String auth);
    PersonResponse changeUserRole(ChangeUserRoleRequest request);
    PersonResponse getProfile(String email);
    void deleteAccount(Long id);
    void deleteStudents();
    void divideStudents(Integer roomCount);
}

package com.skb_lab_proj.springboot_project.api.controllers.user;

import com.skb_lab_proj.springboot_project.api.annotation.UserApiV1;
import com.skb_lab_proj.springboot_project.api.dto.request.CreateUserRequestModel;
import com.skb_lab_proj.springboot_project.api.dto.response.CreateUserResponseModel;
import com.skb_lab_proj.springboot_project.logic.entities.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@UserApiV1
public class UserController {

    private List<User> users = new ArrayList<User>();

    @PostMapping("/createuser")
    public ResponseEntity<CreateUserResponseModel> createUser(
            @RequestBody CreateUserRequestModel model) {
        User user = new User(users.size() + 1, model.name);
        users.add(user);
        return new ResponseEntity<>(new CreateUserResponseModel(user), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}

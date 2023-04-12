package com.skb_lab_proj.springboot_project.api.controllers.user;

import com.skb_lab_proj.springboot_project.api.annotation.UserApiV1;
import com.skb_lab_proj.springboot_project.api.controllers.user.dto.request.CreateUserRequestModel;
import com.skb_lab_proj.springboot_project.api.controllers.user.dto.response.CreateUserResponseModel;
import com.skb_lab_proj.springboot_project.dal.user.User;
import com.skb_lab_proj.springboot_project.logic.managers.UserService;
import com.skb_lab_proj.springboot_project.logic.managers.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static lombok.AccessLevel.PRIVATE;

@UserApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserController {

    @Autowired
    UserService userManager;
    private List<User> users = new ArrayList<User>();

    @PostMapping("/createuser")
    public ResponseEntity<User> createUser(
            @RequestBody CreateUserRequestModel model) {
        User user = new User();
        user.setName(model.name);
        user.setEmail(model.email);
        user.setSurname(model.surname);
        user.setRole(model.role);
        user.setPassword(model.password);
        User a = userManager.createUser(user);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/get/name={id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userManager.getUserById(id), HttpStatus.OK);
    }
}

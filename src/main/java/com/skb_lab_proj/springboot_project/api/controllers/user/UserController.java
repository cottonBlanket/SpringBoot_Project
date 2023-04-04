package com.skb_lab_proj.springboot_project.api.controllers.user;

import com.skb_lab_proj.springboot_project.api.annotation.UserApiV1;
import com.skb_lab_proj.springboot_project.api.controllers.user.dto.request.CreateUserRequestModel;
import com.skb_lab_proj.springboot_project.api.controllers.user.dto.response.CreateUserResponseModel;
import com.skb_lab_proj.springboot_project.dal.user.User;
import com.skb_lab_proj.springboot_project.logic.managers.UserService;
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
    public ResponseEntity<CreateUserResponseModel> createUser(
            @RequestBody CreateUserRequestModel model) {
        User user = new User()
        {

        };
        users.add(user);
        return new ResponseEntity<>(new CreateUserResponseModel(user), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/get/name={username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        return new ResponseEntity<>(userManager.getUserByName(username), HttpStatus.OK);
    }
}

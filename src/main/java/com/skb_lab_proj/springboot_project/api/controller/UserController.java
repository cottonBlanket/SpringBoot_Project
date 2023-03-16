package com.skb_lab_proj.springboot_project.api.controller;

import com.skb_lab_proj.springboot_project.api.dto.request.CreateUserModelRequest;
import com.skb_lab_proj.springboot_project.api.mapping.UserMapperFrom;
import com.skb_lab_proj.springboot_project.logic.entities.User;
import com.skb_lab_proj.springboot_project.logic.services.UserManager;
import com.skb_lab_proj.springboot_project.dal.repositories.UserRepository;
import io.swagger.v3.core.util.Json;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user")
@NoArgsConstructor
public class UserController {

    private UserManager userManager;
    private UserMapperFrom mapper;

    @GetMapping("/")
    public String home(Model model) {

        return "home";
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody CreateUserModelRequest model) {

        User user = mapper.map(model);
        return ResponseEntity.ok(user);
    }

}
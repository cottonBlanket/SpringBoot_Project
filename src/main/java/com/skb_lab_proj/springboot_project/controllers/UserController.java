package com.skb_lab_proj.springboot_project.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

}
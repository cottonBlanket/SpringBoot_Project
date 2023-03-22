package com.skb_lab_proj.springboot_project.logic.managers;


import com.skb_lab_proj.springboot_project.logic.entities.User;

public interface UserService {
    public User getUserByName(String name);
}

package com.skb_lab_proj.springboot_project.logic.entities;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
public class User {

    public int id;

    @NonNull
    public String name;

    public String role;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.role = "user";
    }
}

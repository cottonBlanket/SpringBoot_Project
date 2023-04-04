package com.skb_lab_proj.springboot_project.logic.entities;

import com.skb_lab_proj.springboot_project.dal.base.BaseEntity;
import com.skb_lab_proj.springboot_project.logic.annotation.UserConstraint;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import java.util.List;

@Entity
public class User extends BaseEntity {

    @NonNull
    @Max(32)
    @UserConstraint
    private String name;

    @NonNull
    @Max(40)
    @UserConstraint
    private String surname;

    @NonNull
    @Email
    private String email;

    @NonNull
    private String password;

    @NonNull
    private String role;

    @ManyToMany
    private List<Solution> solutionList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Solution> getSolutionList() {
        return solutionList;
    }

    public void setSolutionList(List<Solution> solutionList) {
        this.solutionList = solutionList;
    }
}

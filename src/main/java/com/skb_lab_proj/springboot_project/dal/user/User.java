package com.skb_lab_proj.springboot_project.dal.user;

import com.skb_lab_proj.springboot_project.dal.base.BaseEntity;
import com.skb_lab_proj.springboot_project.dal.solution.Solution;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Table(name = "User")
public class User extends BaseEntity {
    @Max(32)
    String name;

    String surname;

    String email;

    String password;

    String role;

    @OneToMany(mappedBy = "user")
    List<Solution> solutionList;

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

package com.skb_lab_proj.springboot_project.logic.entities;

import com.skb_lab_proj.springboot_project.dal.base.BaseEntity;
import com.skb_lab_proj.springboot_project.logic.annotation.UserConstraint;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends BaseEntity<Long> {
    @Id
    public long id;
    @NonNull
    @Max(32)
    @UserConstraint
    public String name;
    @NonNull
    @Max(40)
    @UserConstraint
    public String surname;
    @NonNull
    @Email
    public String email;
    @NonNull
    public String password;
    @NonNull
    public String role;
    @ManyToMany
    public List<Solution> solutionList;

    public User(){

    }
}

package com.skb_lab_proj.springboot_project.dal.user;

import com.skb_lab_proj.springboot_project.api.controllers.user.dto.request.CreateUserRequestModel;
import com.skb_lab_proj.springboot_project.dal.base.BaseEntity;
import com.skb_lab_proj.springboot_project.dal.solution.Solution;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 10)
    Long id;

    String name;

    String surname;

    String email;

    String password;

    String role;

    @OneToMany(mappedBy = "person")
    List<Solution> solutionList = new LinkedList<>();

    public static Person createPersonFrom(CreateUserRequestModel model) {
        return Person.builder()
                .name(model.name)
                .surname(model.surname)
                .email(model.email)
                .role(model.role)
                .password(model.password)
                .build();
    }
}

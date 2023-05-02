package com.skb_lab_proj.springboot_project.logic.managers.factory;

import com.skb_lab_proj.springboot_project.api.controllers.account.dto.request.EditProfileRequest;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.request.RegisterRequest;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.response.RegisterResponse;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.response.PersonResponse;
import com.skb_lab_proj.springboot_project.dal.user.Person;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PersonFactory {

    PasswordEncoder passwordEncoder;

    public Person createPersonFrom(RegisterRequest request) {
        return Person
                .builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .role("ROLE_STUDENT")
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
    }

    public RegisterResponse createResponseFrom(Person person) {
        return RegisterResponse
                .builder()
                .id(person.getId())
                .name(person.getName())
                .email(person.getEmail())
                .build();
    }

    public void updatePerson(Person person, EditProfileRequest request) {
        person.setName(request.getName());
        person.setSurname(request.getSurname());
        person.setEmail(request.getEmail());
        person.setPassword(request.getPassword());
    }

    public PersonResponse createPersonResponseFrom(Person person) {
        return PersonResponse
                .builder()
                .id(person.getId())
                .name(person.getName())
                .surname(person.getSurname())
                .email(person.getEmail())
                .password(person.getPassword())
                .group(person.getGroup())
                .build();
    }
}

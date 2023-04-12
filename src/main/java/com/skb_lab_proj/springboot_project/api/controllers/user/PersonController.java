package com.skb_lab_proj.springboot_project.api.controllers.user;

import com.skb_lab_proj.springboot_project.api.annotation.UserApiV1;
import com.skb_lab_proj.springboot_project.api.controllers.user.dto.request.CreateUserRequestModel;
import com.skb_lab_proj.springboot_project.dal.user.Person;
import com.skb_lab_proj.springboot_project.logic.managers.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static lombok.AccessLevel.PRIVATE;

@UserApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PersonController {

    @Autowired
    PersonService personService;
    private List<Person> people = new ArrayList<Person>();

    @PostMapping("/createuser")
    public ResponseEntity<Person> createUser(
            @RequestBody CreateUserRequestModel model) {
        Person person = new Person();
        person.setName(model.name);
        person.setEmail(model.email);
        person.setSurname(model.surname);
        person.setRole(model.role);
        person.setPassword(model.password);
        Person a = personService.createPerson(person);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllUsers() {

        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/get/name={id}")
    public ResponseEntity<Person> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(personService.getUserById(id), HttpStatus.OK);
    }
}
package com.skb_lab_proj.springboot_project.api.controllers.user;

import com.skb_lab_proj.springboot_project.api.annotation.UserApiV1;
import com.skb_lab_proj.springboot_project.api.controllers.user.dto.request.CreateUserRequestModel;
import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
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

    PersonService personService;
    private List<Person> people = new ArrayList<Person>();

    @PostMapping("/createuser")
    public ResponseEntity<Person> createUser(
            @RequestBody CreateUserRequestModel model) {
        Person person = Person.createPersonFrom(model);
        var a = personService.create(person);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllUsers() {

        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/get/name={id}")
    public ResponseEntity<Person> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(personService.get(id), HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Person>> getAll(){
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }
}

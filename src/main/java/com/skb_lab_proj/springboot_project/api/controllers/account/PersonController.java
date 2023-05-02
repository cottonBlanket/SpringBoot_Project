package com.skb_lab_proj.springboot_project.api.controllers.account;

import com.skb_lab_proj.springboot_project.api.annotation.AccountApiV1;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.request.EditProfileRequest;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.request.RegisterRequest;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.response.EditProfileResponse;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.response.RegisterResponse;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.response.PersonResponse;
import com.skb_lab_proj.springboot_project.logic.managers.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;

@AccountApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PersonController {

    PersonService personService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest model) {
        return new ResponseEntity<>(personService.register(model), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<EditProfileResponse> editProfile(@RequestBody EditProfileRequest model) {
        return new ResponseEntity<>(personService.update(model), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(personService.getUser(id), HttpStatus.OK);
    }
}

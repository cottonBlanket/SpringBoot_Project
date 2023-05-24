package com.skb_lab_proj.springboot_project.api.controllers.account;

import com.skb_lab_proj.springboot_project.api.annotation.api.AccountApiV1;
import com.skb_lab_proj.springboot_project.api.annotation.api.ControllerApi;
import com.skb_lab_proj.springboot_project.api.annotation.limit.AccountLimit;
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
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static lombok.AccessLevel.PRIVATE;

@AccountApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PersonController {

    PersonService personService;

    @AccountLimit
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest model) {
        return new ResponseEntity<>(personService.register(model), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<EditProfileResponse> editProfile(@RequestBody @Valid EditProfileRequest model, Authentication auth) {
        return new ResponseEntity<>(personService.update(model, auth.getName()), HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<PersonResponse> getMyProfile(Authentication auth) {
        return new ResponseEntity<>(personService.getProfile(auth.getName()), HttpStatus.OK);
    }
}

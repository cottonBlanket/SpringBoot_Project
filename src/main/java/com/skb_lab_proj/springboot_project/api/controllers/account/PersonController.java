package com.skb_lab_proj.springboot_project.api.controllers.account;

import com.skb_lab_proj.springboot_project.api.annotation.AccountApiV1;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.request.ChangeUserRoleRequest;
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
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;

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
    public ResponseEntity<EditProfileResponse> editProfile(@RequestBody EditProfileRequest model, Authentication auth) {
        return new ResponseEntity<>(personService.update(model, auth.getName()), HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<PersonResponse> getMyProfile(Authentication auth) {
        return new ResponseEntity<>(personService.getProfile(auth.getName()), HttpStatus.OK);
    }
}

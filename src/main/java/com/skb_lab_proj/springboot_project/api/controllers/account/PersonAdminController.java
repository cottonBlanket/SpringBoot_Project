package com.skb_lab_proj.springboot_project.api.controllers.account;

import com.skb_lab_proj.springboot_project.api.annotation.api.AdminApiV1;
import com.skb_lab_proj.springboot_project.api.annotation.api.ControllerApi;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.request.ChangeUserRoleRequest;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.response.PersonResponse;
import com.skb_lab_proj.springboot_project.logic.managers.PersonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AdminApiV1
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PersonAdminController {

    PersonService personService;

    @GetMapping("students/all")
    public ResponseEntity<List<PersonResponse>> getAllStudent(@RequestParam @Nullable Integer room) {
        return new ResponseEntity<>(personService.getAll(room), HttpStatus.OK);
    }

    @PatchMapping("/divide")
    public ResponseEntity<String> setRoom(@RequestParam Integer roomCount) {
        personService.divideStudents(roomCount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity<PersonResponse> deletePerson(@PathVariable Long id) {
        personService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/students/delete")
    public ResponseEntity<String> deleteAllStudents() {
        personService.deleteStudents();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/person/change-user-role")
    public ResponseEntity<PersonResponse> changeUserRole(@RequestBody @Valid ChangeUserRoleRequest request) {
        return new ResponseEntity<>(personService.changeUserRole(request), HttpStatus.OK);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<PersonResponse> getUser(@PathVariable Long id, Authentication auth) {
        return new ResponseEntity<>(personService.getUser(id, auth.getName()), HttpStatus.OK);
    }
}

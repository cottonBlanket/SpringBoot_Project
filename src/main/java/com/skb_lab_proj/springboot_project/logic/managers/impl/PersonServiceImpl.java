package com.skb_lab_proj.springboot_project.logic.managers.impl;

import com.skb_lab_proj.springboot_project.api.controllers.account.dto.request.EditProfileRequest;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.request.RegisterRequest;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.response.EditProfileResponse;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.response.RegisterResponse;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.response.PersonResponse;
import com.skb_lab_proj.springboot_project.dal.user.Person;
import com.skb_lab_proj.springboot_project.dal.user.repositories.PersonRepository;
import com.skb_lab_proj.springboot_project.logic.managers.PersonService;
import com.skb_lab_proj.springboot_project.logic.managers.factory.PersonFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;
    PersonFactory personFactory;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        Person person = personFactory.createPersonFrom(request);
        person = personRepository.save(person);
        return personFactory.createResponseFrom(person);
    }

    @Override
    public EditProfileResponse update(EditProfileRequest request) {
        Person person = personRepository.getReferenceById(request.getId());
        personFactory.updatePerson(person, request);
        personRepository.save(person);
        return EditProfileResponse.builder().id(request.getId()).build();
    }

    @Override
    public PersonResponse getUser(Long id) {
        Person person = personRepository.getReferenceById(id);
        return personFactory.createPersonResponseFrom(person);
    }

//    @Override
//    @Transactional
//    public List<PersonResponse> getAll() {
//        return personRepository.findAll().stream().map(PersonResponse::new).collect(Collectors.toList());
//    }
}

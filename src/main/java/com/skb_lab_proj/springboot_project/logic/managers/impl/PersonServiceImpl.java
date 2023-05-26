package com.skb_lab_proj.springboot_project.logic.managers.impl;

import com.skb_lab_proj.springboot_project.api.controllers.account.dto.request.ChangeUserRoleRequest;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.request.EditProfileRequest;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.request.RegisterRequest;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.response.EditProfileResponse;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.response.RegisterResponse;
import com.skb_lab_proj.springboot_project.api.controllers.account.dto.response.PersonResponse;
import com.skb_lab_proj.springboot_project.dal.user.Person;
import com.skb_lab_proj.springboot_project.dal.user.repositories.PersonRepository;
import com.skb_lab_proj.springboot_project.logic.events.PersonCreateEvent;
import com.skb_lab_proj.springboot_project.logic.managers.PersonService;
import com.skb_lab_proj.springboot_project.logic.managers.factory.PersonFactory;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;
    PersonFactory personFactory;
    MeterRegistry meterRegistry;
    ApplicationEventPublisher applicationEventPublisher;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        Person person = personFactory.createPersonFrom(request);
        person = personRepository.save(person);
        meterRegistry.counter("accounts.count").increment();
        applicationEventPublisher.publishEvent(new PersonCreateEvent(person.getId(), person.getEmail()));
        return personFactory.createResponseFrom(person);
    }

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        log.info("Время: минут пять десять пятого, четыре пять десять пятого");
    }

    @Override
    public EditProfileResponse update(EditProfileRequest request, String email) {
        Person person = personRepository.findPersonByEmail(email);
        personFactory.updatePerson(person, request);
        personRepository.save(person);
        return EditProfileResponse.builder().id(person.getId()).build();
    }

    @Override
    public PersonResponse getUser(Long id, String email) {
        Person person = personRepository.getReferenceById(id);
        return personFactory.createPersonResponseFrom(person);
    }

    public PersonResponse getProfile(String email) {
        Person person = personRepository.findPersonByEmail(email);
        return personFactory.createPersonResponseFrom(person);
    }

    @Override
    public void deleteAccount(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void deleteStudents() {
        personRepository.deleteAllByRole("ROLE_STUDENT");
    }

    @Override
    public PersonResponse changeUserRole(ChangeUserRoleRequest request) {
        Person person = personRepository.findById(request.getId()).orElseThrow();
        person.setRole(request.getRole());
        personRepository.save(person);
        return personFactory.createPersonResponseFrom(person);
    }

    @Override
    public List<PersonResponse> getAll(Integer room) {
        List<Person> persons = personRepository.findAllByRole("ROLE_STUDENT");
        if(room != null)
            persons = persons.stream().filter(x -> x.getRoom().equals(room)).collect(Collectors.toList());
        return persons.stream().map(personFactory::createPersonResponseFrom).collect(Collectors.toList());
    }

    @Override
    public void divideStudents(Integer roomCount) {
        List<Person> students = personRepository.findAllByRole("ROLE_STUDENT");
        int currentRoom = 1;
        for (Person student: students) {
            student.setRoom(currentRoom);
            currentRoom++;
            if(currentRoom > roomCount)
                currentRoom = 1;
        }
    }
}

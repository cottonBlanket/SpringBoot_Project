package com.skb_lab_proj.springboot_project.logic.managers.impl;

import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.dal.user.Person;
import com.skb_lab_proj.springboot_project.dal.user.repositories.PersonRepository;
import com.skb_lab_proj.springboot_project.logic.managers.BaseService;
import com.skb_lab_proj.springboot_project.logic.managers.PersonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;
    @Override
    public Person create(Person dal) {
        return personRepository.save(dal);
    }

    @Override
    public Person get(Long id) {
        var result = personRepository.findById(id).orElseThrow();
        var d = 0;
        return result;
    }

    @Override
    public void update(Person dal) {
        personRepository.save(dal);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }
    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}

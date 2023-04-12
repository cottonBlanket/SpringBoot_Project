package com.skb_lab_proj.springboot_project.logic.managers.impl;

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

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;
    @Override
    public Person create(Person dal) {
        return personRepository.save(dal);
    }

    @Override
    public Person get(Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    @Override
    public void update(Person dal) {
        personRepository.save(dal);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}

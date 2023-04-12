package com.skb_lab_proj.springboot_project.logic.managers;

import com.skb_lab_proj.springboot_project.dal.user.Person;
public interface PersonService {
    public Person getUserById(Long id);

    public Person createPerson(Person person);
}

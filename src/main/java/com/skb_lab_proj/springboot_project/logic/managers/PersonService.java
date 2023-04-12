package com.skb_lab_proj.springboot_project.logic.managers;

import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.dal.user.Person;

import java.util.List;

public interface PersonService extends BaseService<Person> {
    List<Person> getAll();
}

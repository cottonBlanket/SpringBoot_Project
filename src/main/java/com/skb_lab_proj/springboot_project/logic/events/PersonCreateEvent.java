package com.skb_lab_proj.springboot_project.logic.events;

import com.skb_lab_proj.springboot_project.dal.user.Person;
import lombok.Value;

@Value
public class PersonCreateEvent {
    Long id;
    String email;
    public static PersonCreateEvent from(Person person) {
        return new PersonCreateEvent(person.getId(), person.getEmail());
    }
}

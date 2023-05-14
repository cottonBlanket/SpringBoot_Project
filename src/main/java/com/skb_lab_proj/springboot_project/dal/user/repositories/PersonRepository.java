package com.skb_lab_proj.springboot_project.dal.user.repositories;

import com.skb_lab_proj.springboot_project.dal.user.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findPersonByEmail(String email);
    List<Person> deleteAllByRole(String role);
    List<Person> findAllByRoomIsNull();
}

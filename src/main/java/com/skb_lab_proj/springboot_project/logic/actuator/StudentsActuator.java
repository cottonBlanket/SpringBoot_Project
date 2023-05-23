package com.skb_lab_proj.springboot_project.logic.actuator;

import com.skb_lab_proj.springboot_project.dal.user.Person;
import com.skb_lab_proj.springboot_project.dal.user.repositories.PersonRepository;
import com.skb_lab_proj.springboot_project.logic.actuator.factory.StudentFactory;
import com.skb_lab_proj.springboot_project.logic.actuator.response.Student;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint(id = "students")
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StudentsActuator {

    PersonRepository personRepository;
    StudentFactory studentFactory;

    @ReadOperation
    public List<Student> students() {
        List<Person> students = personRepository.deleteAllByRole("ROLE_STUDENT");
        return students.stream().map(studentFactory::createStudentFrom).collect(Collectors.toList());
    }
}

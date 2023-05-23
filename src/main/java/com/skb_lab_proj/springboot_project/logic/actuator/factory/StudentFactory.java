package com.skb_lab_proj.springboot_project.logic.actuator.factory;

import com.skb_lab_proj.springboot_project.dal.solution.Solution;
import com.skb_lab_proj.springboot_project.dal.user.Person;
import com.skb_lab_proj.springboot_project.logic.actuator.response.Student;
import com.skb_lab_proj.springboot_project.logic.actuator.response.StudentSolution;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StudentFactory {

    public Student createStudentFrom(Person person) {
        return Student
                .builder()
                .name(person.getSurname() + " " + person.getName())
                .email(person.getEmail())
                .solutions(
                        person.getSolutionList()
                                .stream()
                                .map(this::createStudentSolutionFrom)
                                .collect(Collectors.toList()))
                .build();
    }

    public StudentSolution createStudentSolutionFrom(Solution solution) {
        return StudentSolution
                .builder()
                .lesson(solution.getTask().getLesson().getName())
                .task(solution.getTask().getName())
                .link(solution.getLink())
                .status(solution.getStatus())
                .scores(solution.getScores())
                .build();
    }
}

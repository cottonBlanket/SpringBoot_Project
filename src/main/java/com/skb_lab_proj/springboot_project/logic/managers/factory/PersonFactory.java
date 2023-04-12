//package com.skb_lab_proj.springboot_project.logic.managers.factory;
//
//import com.skb_lab_proj.springboot_project.dal.solution.Solution;
//import com.skb_lab_proj.springboot_project.dal.solution.repositories.SolutionRepository;
//import com.skb_lab_proj.springboot_project.dal.user.Person;
//import com.skb_lab_proj.springboot_project.dal.user.repositories.PersonRepository;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
//public class PersonFactory {
//    SolutionRepository solutionRepository;
//
//    public PersonRepository createPersonResponseFrom(Person person) {
//        return new PersonRepository(
//                person.getId(),
//                person.getSurname(),
//                person.getEmail(),
//                person.getRole(),
//                person.getPassword(),
//                createSolutionFrom(person.getManufacturer())
//        ) {
//        };
//    }
//
//    private PersonRepository createManufacturerInfo(Solution solution) {
//        return new PersonRepository(
//                solution.getId(),
//                solution.()
//        );
//    }
//
//
//}

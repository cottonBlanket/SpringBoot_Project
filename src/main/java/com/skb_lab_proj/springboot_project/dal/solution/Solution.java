package com.skb_lab_proj.springboot_project.dal.solution;

import com.skb_lab_proj.springboot_project.dal.solution.enums.Status;
import com.skb_lab_proj.springboot_project.dal.task.Task;
import com.skb_lab_proj.springboot_project.dal.user.Person;
import lombok.*;

import javax.persistence.*;
import java.util.Stack;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "solution")
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 10)
    Long id;
    String gitLink;
    Status status;
    int scores;

    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;

    @ManyToOne
    @JoinColumn(name = "task_id")
    Task task;

}

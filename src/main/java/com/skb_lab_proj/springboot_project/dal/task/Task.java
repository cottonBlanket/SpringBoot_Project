package com.skb_lab_proj.springboot_project.dal.task;

import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.dal.solution.Solution;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 10)
    Long id;
    String name;
    String text;
    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
    List<Solution> solutions = new LinkedList<>();
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    Lesson lesson;
}

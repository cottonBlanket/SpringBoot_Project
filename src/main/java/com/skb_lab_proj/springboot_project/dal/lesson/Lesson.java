package com.skb_lab_proj.springboot_project.dal.lesson;

import com.skb_lab_proj.springboot_project.dal.task.Task;
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
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 10)
    Long id;
    String name;
    @OneToMany(mappedBy = "lesson", fetch = FetchType.EAGER)
    List<Task> tasks = new LinkedList<>();
}

package com.skb_lab_proj.springboot_project.dal.task;

import com.skb_lab_proj.springboot_project.dal.base.BaseEntity;
import com.skb_lab_proj.springboot_project.dal.lesson.Lesson;
import com.skb_lab_proj.springboot_project.dal.solution.Solution;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 10)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "gitLink")
    String gitLink;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    List<Solution> solutions = new LinkedList<>();

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    Lesson lesson;

    public Task() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGitLink() {
        return gitLink;
    }

    public void setGitLink(String gitLink) {
        this.gitLink = gitLink;
    }

    public List<Solution> getSolutionList() {
        return solutions;
    }

    public void setSolutionList(List<Solution> solutionList) {
        this.solutions = solutionList;
    }
}

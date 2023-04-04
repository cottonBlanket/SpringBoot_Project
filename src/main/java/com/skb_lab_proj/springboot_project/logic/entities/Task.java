package com.skb_lab_proj.springboot_project.logic.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {
    @Id
    public long id;
    @Column(name = "name")
    public String name;
    @Column(name = "gitLink")
    public String gitLink;
    @ManyToMany
    public List<Solution> solutionList;

    public Task(){

    }
}

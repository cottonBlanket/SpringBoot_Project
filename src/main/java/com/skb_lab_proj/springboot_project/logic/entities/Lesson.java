package com.skb_lab_proj.springboot_project.logic.entities;

import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    public long id;
    public String name;
    @ManyToMany
    public List<Task> tasks;
    public Lesson(){

    }
}

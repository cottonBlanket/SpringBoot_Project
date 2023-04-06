package com.skb_lab_proj.springboot_project.dal.lesson;

import com.skb_lab_proj.springboot_project.dal.base.BaseEntity;
import com.skb_lab_proj.springboot_project.dal.task.Task;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
public class Lesson extends BaseEntity {
    @NonNull
    private String name;
    @ManyToMany
    private List<Task> tasks;

    public Lesson(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

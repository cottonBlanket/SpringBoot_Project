package com.skb_lab_proj.springboot_project.dal.task;

import com.skb_lab_proj.springboot_project.dal.base.BaseEntity;
import com.skb_lab_proj.springboot_project.dal.solution.Solution;

import javax.persistence.*;
import java.util.List;

@Entity
public class Task extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "gitLink")
    private String gitLink;

    @ManyToMany
    private List<Solution> solutionList;

    public Task(){

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
        return solutionList;
    }

    public void setSolutionList(List<Solution> solutionList) {
        this.solutionList = solutionList;
    }
}

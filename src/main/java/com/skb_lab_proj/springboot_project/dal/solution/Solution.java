package com.skb_lab_proj.springboot_project.dal.solution;

import com.skb_lab_proj.springboot_project.dal.base.BaseEntity;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "solution")
public class Solution extends BaseEntity {
    private String gitLink;
    private Boolean allow;

    public String getGitLink() {
        return gitLink;
    }

    public void setGitLink(String gitLink) {
        this.gitLink = gitLink;
    }

    public Boolean getAllow() {
        return allow;
    }

    public void setAllow(Boolean allow) {
        this.allow = allow;
    }
}

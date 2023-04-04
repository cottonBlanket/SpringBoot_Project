package com.skb_lab_proj.springboot_project.logic.entities;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "solution")
public class Solution {
    @Id
    public long id;
    public String gitLink;
    public String allow;

    public Solution(){

    }
}

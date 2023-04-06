package com.skb_lab_proj.springboot_project.dal.base;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public abstract class BaseEntity {
    @Id
    private java.lang.Long id;

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Long getId() {
        return id;
    }

    public BaseEntity(){}
}

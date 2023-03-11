package com.skb_lab_proj.springboot_project.dal.base.Entities;

import org.springframework.data.annotation.Id;

public class BaseDal<T> {

    @org.springframework.data.annotation.Id
    public T Id;
}

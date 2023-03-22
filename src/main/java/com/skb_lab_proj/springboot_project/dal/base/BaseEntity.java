package com.skb_lab_proj.springboot_project.dal.base;

import lombok.Getter;

@Getter
public abstract class BaseEntity<ID> {
    private ID id;

    public boolean isIdNotInitialized() {
        return id == null;
    }

    public void initId(ID id) {
        if (isIdNotInitialized())
            this.id = id;
    }
}

package com.skb_lab_proj.springboot_project.api.validation.constraint;

import com.skb_lab_proj.springboot_project.api.validation.annotation.RoleConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoleValidator implements ConstraintValidator<RoleConstraint, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("ROLE_ADMIN") || value.equals("ROLE_STUDENT");
    }
}

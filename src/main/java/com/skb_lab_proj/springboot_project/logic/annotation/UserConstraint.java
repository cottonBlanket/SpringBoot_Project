package com.skb_lab_proj.springboot_project.logic.annotation;

import lombok.NonNull;

import javax.validation.Constraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@NonNull
@Min(7)
@Max(130)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UserValidator.class)
public @interface UserConstraint {
    String message() default "Password not valid";
}

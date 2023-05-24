package com.skb_lab_proj.springboot_project.api.validation.annotation;

import com.skb_lab_proj.springboot_project.api.validation.constraint.RoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target({ FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { RoleValidator.class})
@Documented
public @interface RoleConstraint {
    String message() default "the role must be within {\"ROLE_ADMIN\", \"ROLE_STUDENT\" }";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}

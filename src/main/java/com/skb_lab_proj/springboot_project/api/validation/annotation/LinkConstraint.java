package com.skb_lab_proj.springboot_project.api.validation.annotation;

import com.skb_lab_proj.springboot_project.api.validation.constraint.LinkValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target({ FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { LinkValidator.class})
@Documented
public @interface LinkConstraint {
    String message() default "The response to the task must be a link to the pull request";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}

package com.skb_lab_proj.springboot_project.api.validation.constraint;

import com.skb_lab_proj.springboot_project.api.validation.annotation.LinkConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class LinkValidator implements ConstraintValidator<LinkConstraint, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String regex = "https://github.com/^[A-Za-z0-9+_.-]/[A-Za-z0-9+_.-]/pull/[0-9]$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(value).matches();
    }
}

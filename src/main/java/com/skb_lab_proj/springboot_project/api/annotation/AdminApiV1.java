package com.skb_lab_proj.springboot_project.api.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Documented
@RestController
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(value = "/api/v1/admin", produces = APPLICATION_JSON_VALUE)
public @interface AdminApiV1 {
}

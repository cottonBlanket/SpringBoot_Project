package com.skb_lab_proj.springboot_project.api.advice;


import com.skb_lab_proj.springboot_project.api.exception.ForbiddenException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static org.springframework.http.ResponseEntity.status;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice(basePackages = "com.skb_lab_proj.springboot_project.api.controllers")
@RequiredArgsConstructor
public class ForbiddenAdvice {

    @ExceptionHandler({ForbiddenException.class})
    public ResponseEntity<String> forbidden(Exception e) {

        return status(HttpStatus.FORBIDDEN)
                .body(e.getMessage());
    }
}
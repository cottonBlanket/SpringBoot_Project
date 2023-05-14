package com.skb_lab_proj.springboot_project.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenException  extends RuntimeException{
    public ForbiddenException() {
        super("Нет доступа");
    }

    public ForbiddenException(String message) {
        super(message);
    }

}

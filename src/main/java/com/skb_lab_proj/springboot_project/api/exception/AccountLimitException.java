package com.skb_lab_proj.springboot_project.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AccountLimitException  extends RuntimeException{
    public AccountLimitException(String ex){
        super(ex);
    }
}

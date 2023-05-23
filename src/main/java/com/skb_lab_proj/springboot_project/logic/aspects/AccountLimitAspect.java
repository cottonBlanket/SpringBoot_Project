package com.skb_lab_proj.springboot_project.logic.aspects;

import com.skb_lab_proj.springboot_project.api.exception.AccountLimitException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Aspect
@Component
public class AccountLimitAspect {

    private Map<String, Integer> accountAccessMap = new ConcurrentHashMap<>();
    @Value("${account.limit}")
    private int accountLimit;

    @Before("@annotation(com.skb_lab_proj.springboot_project.api.annotation.limit.AccountLimit)")
    public void  beforeApiLimit(JoinPoint joinPoint) throws AccountLimitException {
        var methodName = joinPoint.getSignature().getName();
        var count = accountAccessMap.getOrDefault(methodName, 0) + 1;
        accountAccessMap.put(methodName, count);
        if (count > accountLimit) {
            throw new AccountLimitException("AccountLimitException");
        }
    }
}

package com.skb_lab_proj.springboot_project.logic.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RequestMetrics {

    MeterRegistry meterRegistry;

    @Pointcut("within(com.skb_lab_proj.springboot_project.api.controllers..*)")
    public void controllers() {}

    @Around("controllers()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        meterRegistry.counter("requests.count").increment();
        long startAt = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            meterRegistry.timer("requests.timer").record(System.currentTimeMillis() - startAt, TimeUnit.MILLISECONDS);
        }
    }
}

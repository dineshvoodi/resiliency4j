package com.example.resiliency4J.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Aspect // This creates an Aspect
@Component
public class AOPLogger {

    // Using @Around, we create Advice to execute Around
    // the Join Point method which matches the below pointcut expression
    @Around(value = "execution(* com.example.resiliency4J.service..*(..))")
    public Object joinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringTypeName();
        String methodName = methodSignature.getName();

        Long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // capture the response and return back
        Long endTime = System.currentTimeMillis();
        log.info("Request completed in " + (endTime - startTime) + " - class " + className);
        return result;
    }

}

package com.app.aspect.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class LogAspect {
//    @Before("@annotation(com.app.aspect.aspect.annotation.LogStatus)")
//    public void beforeStart(JoinPoint joinPoint){
//        log.info("join point: " + joinPoint);
//        log.info("method: " + joinPoint.getSignature().getName());
//        log.info("arguments: " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", ")));
//    }
//
//    @AfterReturning(value = "@annotation(com.app.aspect.aspect.annotation.LogStatus)", returning = "returnValue")
//    public void afterReturning(JoinPoint joinPoint, Integer returnValue){
//        log.info("after returning");
//        log.info("return value: {}", returnValue);
//    }
//
//    @AfterThrowing(value = "@annotation(com.app.aspect.aspect.annotation.LogStatus)", throwing = "e")
//    public void afterThrowing(Exception e){
//        log.info(e.getMessage());
//        log.info("wrong parameter");
//    }
//
//    @After("@annotation(com.app.aspect.aspect.annotation.LogStatus)")
//    public void afterStart(JoinPoint joinPoint){
//        log.info("join point: " + joinPoint);
//        log.info("method: " + joinPoint.getSignature().getName());
//        log.info("arguments: " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", ")));
//    }

    @Around("@annotation(com.app.aspect.aspect.annotation.LogStatus)")
    public Integer around(ProceedingJoinPoint proceedingJoinPoint){
        log.info("poin cut: {}", proceedingJoinPoint);
        Integer result = 0;

        try {
            result = (Integer)proceedingJoinPoint.proceed();
        }catch (NumberFormatException e){
            log.info("잘못된 입력 값");
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return result + 10;
    }
}

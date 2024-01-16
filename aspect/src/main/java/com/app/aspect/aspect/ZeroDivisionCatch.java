package com.app.aspect.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class ZeroDivisionCatch {
    @Around("@annotation(com.app.aspect.aspect.annotation.ZeroDivision)")
    public int around(ProceedingJoinPoint proceedingJoinPoint){
        log.info("point cut: " + proceedingJoinPoint);

        int value = 0;

        try {
            value = (Integer)proceedingJoinPoint.proceed();
        } catch (ArithmeticException e){
          log.info("0으로 나눌 수 없습니다.");

        } catch (Throwable throwable){
            throwable.printStackTrace();
        }

        return value;
    }
}

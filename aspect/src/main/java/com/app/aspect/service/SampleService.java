package com.app.aspect.service;

import com.app.aspect.aspect.annotation.LogStatus;
import com.app.aspect.aspect.annotation.ZeroDivision;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.Integer.parseInt;

@Service
@Slf4j
public class SampleService {
    @LogStatus
    public Integer doAdd(String str1, String str2) {
        log.info("핵심 로직");
        return parseInt(str1) + parseInt(str2);
    }
    
//    두 정수의 나눗셈 결과 중 몫 리턴
    @ZeroDivision
    public int divide(int number1, int number2){
        int value = number1 / number2;
        return value;
    }
}

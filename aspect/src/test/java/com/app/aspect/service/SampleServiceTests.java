package com.app.aspect.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SampleServiceTests {
    @Autowired
    private SampleService sampleService;

    @Test
    public void test(){
//        log.info("result: {}", sampleService.doAdd("한동석", "3"));
        log.info("value: {}", sampleService.divide(10, 3));
    }
}

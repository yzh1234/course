package com.yzh.course.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class expection {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> catchExpection(Exception e) {
        e.printStackTrace();
        ResponseEntity result = new ResponseEntity("系统繁忙", HttpStatus.EXPECTATION_FAILED);
        return result;
    }
}

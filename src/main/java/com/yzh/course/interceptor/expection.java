package com.yzh.course.interceptor;

import com.yzh.course.entity.JsonMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class expection {
    @ExceptionHandler(Exception.class)
    public JsonMessage<String> catchExpection(Exception e) {
        e.printStackTrace();
        JsonMessage result = new JsonMessage("fail","系统繁忙");
        return result;
    }
}

package com.travel.payment.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class RespHandler {
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus status, Object responseObject){
        Map<String,Object> response = new LinkedHashMap<>();
        response.put("status", status.value());
        response.put("massage", message);
        response.put("data",responseObject);
        return new ResponseEntity<>(response, status);
    }

}

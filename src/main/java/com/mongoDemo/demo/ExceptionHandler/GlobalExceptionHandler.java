package com.mongoDemo.demo.ExceptionHandler;

import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<HashMap<String,String>> exceptionHandler(Exception er, WebRequest wr){
        HashMap<String, String> small= new HashMap<>();
        small.put("error",er.getMessage());
        small.put("Description",wr.getDescription(false));
        return new ResponseEntity<HashMap<String,String>>(small, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<HashMap<String,String>> validationHandler(ValidationException er, WebRequest wr){
        HashMap<String, String> small= new HashMap<>();
        small.put("error",er.getMessage());
        small.put("Description",wr.getDescription(false));
        return new ResponseEntity<HashMap<String,String>>(small, HttpStatus.BAD_REQUEST);

    }
}

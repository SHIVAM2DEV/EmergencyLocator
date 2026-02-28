package com.EmergencyLocator.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ApiError {
    private LocalDateTime timeStamp;
    private String error;
    private HttpStatus statusCode;

    public ApiError(){
        this.timeStamp = LocalDateTime.now();
    }

    public ApiError(String error, HttpStatus statusCode){
        this();
        this.error = error;
        this.statusCode = statusCode;
    }


}

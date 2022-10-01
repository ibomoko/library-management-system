package com.me.librarymanagementsystem.error;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorResponse {

    private final String message;
    private final HttpStatus status;
    private final Integer statusCode;
    private final Date timestamp;

    public ErrorResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
        timestamp=new Date();
        statusCode=status.value();
    }
}

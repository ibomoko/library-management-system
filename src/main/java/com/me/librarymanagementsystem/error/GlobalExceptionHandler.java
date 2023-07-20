package com.me.librarymanagementsystem.error;


import com.me.librarymanagementsystem.error.exception.AuthorizationException;
import com.me.librarymanagementsystem.error.exception.ResourceAlreadyExistException;
import com.me.librarymanagementsystem.error.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception){
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExist(ResourceAlreadyExistException exception){
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage(), HttpStatus.CONFLICT),HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExist(AuthorizationException exception){
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage(), HttpStatus.UNAUTHORIZED), HttpStatus.UNAUTHORIZED);
    }

}

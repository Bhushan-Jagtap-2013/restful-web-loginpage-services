package com.loginpage.rest.webservices.restfulwebloginpageservices.user;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        CustomExceptionResponse cr = new CustomExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return  new ResponseEntity(cr, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
        CustomExceptionResponse cr = new CustomExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return  new ResponseEntity(cr, HttpStatus.NOT_FOUND);
    }

    /*
    Override binding exception to provide appropriate message on validation failure.
     */

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomExceptionResponse cr = new CustomExceptionResponse(new Date(), "Validation Failed on input arguments", ex.getBindingResult().toString());
        return  new ResponseEntity(cr, HttpStatus.BAD_REQUEST);
    }
}

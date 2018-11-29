package com.loginpage.rest.webservices.restfulwebloginpageservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // set the return status to 404
public class UserNotFoundException extends RuntimeException { // we have created un-checked
    // (no need to compulsory handle) RunTimeException
    public UserNotFoundException(String s) {
        super(s);
    }
}

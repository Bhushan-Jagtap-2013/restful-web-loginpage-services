package com.loginpage.rest.webservices.restfulwebloginpageservices;

public class HelloWorldBean {
    private String message;

    HelloWorldBean(String message) {
        this.message = message;
    }

    // if we will not provide getter then we will face issue while
    // converting bean during HTML display
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}

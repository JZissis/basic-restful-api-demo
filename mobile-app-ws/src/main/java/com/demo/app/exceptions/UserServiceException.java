package com.demo.app.exceptions;

public class UserServiceException extends RuntimeException{

    public UserServiceException(String message){
        super(message);
    }
}

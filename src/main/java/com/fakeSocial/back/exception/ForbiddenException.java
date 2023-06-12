package com.fakeSocial.back.exception;

public class ForbiddenException extends Exception{
    public ForbiddenException(String message){
        super(message);
    }
    public ForbiddenException(){}
}

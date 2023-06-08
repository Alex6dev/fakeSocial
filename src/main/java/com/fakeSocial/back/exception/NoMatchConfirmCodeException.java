package com.fakeSocial.back.exception;

public class NoMatchConfirmCodeException extends Exception{
    public NoMatchConfirmCodeException(String message){
        super(message);
    }
    public NoMatchConfirmCodeException(){}
}

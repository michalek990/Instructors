package com.example.instructors.Exception;

public class ForbiddenException extends RuntimeException{

    public ForbiddenException(String message){
        super(message);
    }
}

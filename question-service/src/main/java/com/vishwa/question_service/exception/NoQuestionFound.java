package com.vishwa.question_service.exception;

public class NoQuestionFound extends RuntimeException{
    public NoQuestionFound(String message){
        super(message);
    }
}

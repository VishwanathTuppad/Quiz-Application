package com.vishwa.question_service.exception;

public class NoQuestionsFoundWithCategory extends RuntimeException{
    public NoQuestionsFoundWithCategory(String message){
        super(message);
    }
}

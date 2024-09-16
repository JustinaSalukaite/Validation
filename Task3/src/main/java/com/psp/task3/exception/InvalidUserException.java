package com.psp.task3.exception;

public class InvalidUserException extends Exception {

    public InvalidUserException(String errorMessage) {
        super(errorMessage);
    }
}

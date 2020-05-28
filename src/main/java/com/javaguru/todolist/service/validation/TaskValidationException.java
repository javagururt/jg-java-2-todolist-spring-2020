package com.javaguru.todolist.service.validation;

public class TaskValidationException extends RuntimeException {

    public TaskValidationException(String message) {
        super(message);
    }
}

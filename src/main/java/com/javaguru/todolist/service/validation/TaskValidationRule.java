package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.dto.TaskDto;

public interface TaskValidationRule {

    void validate(TaskDto taskDto);

    default void checkNotNull(TaskDto taskDto) {
        if (taskDto == null) {
            throw new IllegalArgumentException("Task must be not null.");
        }
    }
}

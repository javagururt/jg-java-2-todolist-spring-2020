package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.dto.TaskDto;

import org.springframework.stereotype.Component;

@Component
public class TaskDescriptionValidationRule implements TaskValidationRule {

    @Override
    public void validate(TaskDto taskDto) {
        checkNotNull(taskDto);
        if (taskDto.getDescription() == null || taskDto.getDescription().isEmpty()) {
            throw new TaskValidationException("Task description must be not empty.");
        }
    }
}

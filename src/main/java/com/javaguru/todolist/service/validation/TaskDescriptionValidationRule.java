package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.dto.TaskDto;

class TaskDescriptionValidationRule implements TaskValidationRule {

    @Override
    public void validate(TaskDto taskDto) {
        if (taskDto.getDescription() == null || taskDto.getDescription().isEmpty()) {
            throw new TaskValidationException("Task description must be not empty.");
        }
    }
}

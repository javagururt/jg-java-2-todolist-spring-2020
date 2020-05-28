package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.domain.TaskEntity;
import com.javaguru.todolist.dto.TaskDto;

class TaskNameValidationRule implements TaskValidationRule {

    @Override
    public void validate(TaskDto taskDto) {
        if (taskDto.getName() == null) {
            throw new TaskValidationException("Task name must be not null.");
        }
    }
}

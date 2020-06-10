package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.dto.TaskDto;

import org.springframework.stereotype.Component;

@Component
public class TaskNameValidationRule implements TaskValidationRule {

    @Override
    public void validate(TaskDto taskDto) {
        checkNotNull(taskDto);
        if (taskDto.getName() == null) {
            throw new TaskValidationException("Task name must be not null.");
        }
    }
}

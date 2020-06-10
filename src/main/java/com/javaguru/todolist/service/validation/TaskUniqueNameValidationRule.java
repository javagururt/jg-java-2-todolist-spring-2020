package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.dto.TaskDto;
import com.javaguru.todolist.repository.TaskRepository;

import org.springframework.stereotype.Component;

@Component
public class TaskUniqueNameValidationRule implements TaskValidationRule {

    private final TaskRepository repository;

    public TaskUniqueNameValidationRule(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(TaskDto taskDto) {
        checkNotNull(taskDto);
        if (repository.findTaskByName(taskDto.getName()).isPresent()) {
            throw new IllegalArgumentException(ValidationExceptionMessages.UNIQUE_NAME_VALIDATION_MSG);
        }
    }

}

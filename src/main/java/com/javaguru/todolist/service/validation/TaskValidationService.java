package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.dto.TaskDto;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TaskValidationService {

    private final Set<TaskValidationRule> validationRules;

    public TaskValidationService(Set<TaskValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(TaskDto taskDto) {
//        validationRules.forEach(rule -> rule.validate(task));
        for (TaskValidationRule rule : validationRules) {
            rule.validate(taskDto);
        }
    }
}

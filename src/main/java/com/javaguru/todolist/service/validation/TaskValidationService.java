package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.domain.TaskEntity;
import com.javaguru.todolist.dto.TaskDto;

import java.util.HashSet;
import java.util.Set;

public class TaskValidationService {

    private final Set<TaskValidationRule> validationRules = new HashSet<>();

    public TaskValidationService() {
        validationRules.add(new TaskNameValidationRule());
        validationRules.add(new TaskDescriptionValidationRule());
    }

    public void validate(TaskDto taskDto) {
//        validationRules.forEach(rule -> rule.validate(task));
        for (TaskValidationRule rule : validationRules) {
            rule.validate(taskDto);
        }
    }
}

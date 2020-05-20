package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.domain.Task;

class TaskDescriptionValidationRule implements TaskValidationRule {

    @Override
    public void validate(Task task) {
        if (task.getDescription() == null || task.getDescription().isEmpty()) {
            throw new TaskValidationException("Task description must be not empty.");
        }
    }
}

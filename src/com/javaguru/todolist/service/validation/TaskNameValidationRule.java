package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.domain.Task;

class TaskNameValidationRule implements TaskValidationRule {

    @Override
    public void validate(Task task) {
        if (task.getName() == null) {
            throw new TaskValidationException("Task name must be not null.");
        }
    }
}

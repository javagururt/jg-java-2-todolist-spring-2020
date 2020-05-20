package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.domain.Task;

public interface TaskValidationRule {

    void validate(Task task);

}

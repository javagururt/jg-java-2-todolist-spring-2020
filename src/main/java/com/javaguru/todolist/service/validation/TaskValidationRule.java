package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.dto.TaskDto;

public interface TaskValidationRule {

    void validate(TaskDto taskDto);

}

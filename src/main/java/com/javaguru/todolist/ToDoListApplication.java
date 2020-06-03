package com.javaguru.todolist;

import com.javaguru.todolist.console.ConsoleUI;
import com.javaguru.todolist.mappers.BeanMapper;
import com.javaguru.todolist.repository.TaskInMemoryRepository;
import com.javaguru.todolist.repository.TaskRepository;
import com.javaguru.todolist.service.TaskService;
import com.javaguru.todolist.service.validation.TaskDescriptionValidationRule;
import com.javaguru.todolist.service.validation.TaskNameValidationRule;
import com.javaguru.todolist.service.validation.TaskUniqueNameValidationRule;
import com.javaguru.todolist.service.validation.TaskValidationRule;
import com.javaguru.todolist.service.validation.TaskValidationService;

import java.util.HashSet;
import java.util.Set;

public class ToDoListApplication {

    public static void main(String[] args) {
        TaskRepository repository = new TaskInMemoryRepository();

        Set<TaskValidationRule> rules = new HashSet<>();
        rules.add(new TaskNameValidationRule());
        rules.add(new TaskDescriptionValidationRule());
        rules.add(new TaskUniqueNameValidationRule(repository));

        TaskValidationService validationService = new TaskValidationService(rules);
        BeanMapper beanMapper = new BeanMapper();
        TaskService service = new TaskService(repository, validationService, beanMapper);
        ConsoleUI ui = new ConsoleUI(service);
        ui.start();
    }

}

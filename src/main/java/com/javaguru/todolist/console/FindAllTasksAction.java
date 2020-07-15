package com.javaguru.todolist.console;

import com.javaguru.todolist.service.TaskService;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
class FindAllTasksAction implements MenuAction {

    private final TaskService taskService;

    FindAllTasksAction(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void execute() {
        taskService.findAll()
                .forEach(System.out::println);
    }

    @Override
    public String getMenuActionName() {
        return "Find all tasks";
    }
}

package com.javaguru.todolist.console;

import com.javaguru.todolist.domain.TaskEntity;
import com.javaguru.todolist.service.TaskService;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(1)
class FindTaskByIdAction implements MenuAction {

    private final TaskService service;

    FindTaskByIdAction(TaskService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task id: ");
        Long id = Long.valueOf(scanner.nextLine());
        TaskEntity taskEntity = service.findTaskById(id);
        System.out.println("Task found: " + taskEntity);
    }

    @Override
    public String getMenuActionName() {
        return "Find task by id";
    }

}

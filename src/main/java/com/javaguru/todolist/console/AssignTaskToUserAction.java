package com.javaguru.todolist.console;

import com.javaguru.todolist.service.UserTaskService;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(6)
class AssignTaskToUserAction implements MenuAction {

    private final UserTaskService service;

    AssignTaskToUserAction(UserTaskService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter task id: ");
        Long taskId = scanner.nextLong();
        System.out.println("Please enter user id: ");
        Long userId = scanner.nextLong();
        service.assignTaskToUser(taskId, userId);
    }

    @Override
    public String getMenuActionName() {
        return "Assign task to user";
    }
}

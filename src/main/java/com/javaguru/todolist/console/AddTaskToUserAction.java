package com.javaguru.todolist.console;

import com.javaguru.todolist.domain.TaskEntity;
import com.javaguru.todolist.service.TaskService;
import com.javaguru.todolist.service.UserService;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(6)
class AddTaskToUserAction implements MenuAction {

    private final UserService userService;
    private final TaskService taskService;

    AddTaskToUserAction(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter task id: ");
        Long taskId = scanner.nextLong();
        System.out.println("Please enter user id: ");
        Long userId = scanner.nextLong();
        TaskEntity task = taskService.findTaskById(taskId);
        userService.addTask(task, userId);
    }

    @Override
    public String getMenuActionName() {
        return "Add task to user";
    }
}

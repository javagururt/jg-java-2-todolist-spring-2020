package com.javaguru.todolist.console;

import com.javaguru.todolist.dto.TaskDto;
import com.javaguru.todolist.service.TaskService;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(0)
public class CreateTaskAction implements MenuAction {

    private final TaskService service;

    public CreateTaskAction(TaskService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task name: ");
        String name = scanner.nextLine();
        System.out.println("Enter task description: ");
        String description = scanner.nextLine();
        TaskDto dto = new TaskDto();
        dto.setName(name);
        dto.setDescription(description);
        TaskDto taskDto = service.save(dto);
        System.out.println("Task successfully created: " + taskDto);
    }

    @Override
    public String getMenuActionName() {
        return "Create task";
    }
}

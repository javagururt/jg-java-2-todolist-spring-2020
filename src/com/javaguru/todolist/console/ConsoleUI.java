package com.javaguru.todolist.console;

import com.javaguru.todolist.domain.Task;
import com.javaguru.todolist.service.TaskService;
import com.javaguru.todolist.service.validation.TaskNotFoundException;
import com.javaguru.todolist.service.validation.TaskValidationException;

import java.util.Scanner;

public class ConsoleUI {

    private final TaskService service = new TaskService();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("1. Create task.");
                System.out.println("2. Find task by id.");
                System.out.println("3. Exit.");
                int userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter task name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter task description: ");
                        String description = scanner.nextLine();
                        Task task = new Task(name, description);
                        Task createdTask = service.save(task);
                        System.out.println("Task successfully created: " + createdTask);
                        break;
                    case 2:
                        System.out.println("Enter task id: ");
                        Long id = Long.valueOf(scanner.nextLine());
                        Task task1 = service.findTaskById(id);
                        System.out.println("Task found: " + task1);
                        break;
                    case 3:
                        return;
                }
            } catch (TaskValidationException e) {
                System.out.println("Task validation failed. Message: " + e.getMessage());
            } catch (TaskNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
                e.printStackTrace();
            }
        }
    }
}

package com.javaguru.todolist;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ToDoListApplication {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Long, Task> repository = new HashMap<>();
        long taskIdSequence = 0L;

        while (true) {
            try {
                System.out.println("1. Create task");
                System.out.println("2. Find task by id");
                System.out.println("3. Exit");
                int userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter task name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter task description: ");
                        String description = scanner.nextLine();

                        Task task = new Task();
                        task.setName(name);
                        task.setDescription(description);

                        if (task.getName() == null) {
                            throw new IllegalArgumentException("Task name must be not null.");
                        }

                        task.setId(taskIdSequence++);
                        repository.put(task.getId(), task);

                        System.out.println("Task created, id:  " + task.getId());
                        break;
                    case 2:
                        System.out.println("Enter task id: ");
                        Long id = Long.valueOf(scanner.nextLine());
                        Task findTaskResult = repository.get(id);
                        System.out.println(findTaskResult);
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}

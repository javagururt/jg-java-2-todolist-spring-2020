package com.javaguru.todolist.console;

import com.javaguru.todolist.service.validation.TaskNotFoundException;
import com.javaguru.todolist.service.validation.TaskValidationException;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleUI {

    private final List<MenuAction> actions;

    public ConsoleUI(List<MenuAction> actions) {
        this.actions = actions;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                for (int i = 0; i < actions.size(); i++) {
                    System.out.println(i + ". " + actions.get(i).getMenuActionName());
                }
                int userInput = Integer.parseInt(scanner.nextLine());
                if (userInput < 0 || userInput >= actions.size()) {
                    throw new IllegalArgumentException("Incorrect input");
                }
                actions.get(userInput).execute();
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

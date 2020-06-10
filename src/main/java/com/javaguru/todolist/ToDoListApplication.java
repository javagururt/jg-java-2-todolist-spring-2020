package com.javaguru.todolist;

import com.javaguru.todolist.config.AppConfig;
import com.javaguru.todolist.console.ConsoleUI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ToDoListApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConsoleUI consoleUI = context.getBean(ConsoleUI.class);
        consoleUI.start();
    }

}

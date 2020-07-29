package com.javaguru.todolist.console;

import com.javaguru.todolist.domain.UserEntity;
import com.javaguru.todolist.service.UserService;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(4)
class CreateUserAction implements MenuAction {


    private final UserService userService;

    CreateUserAction(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        System.out.println("Please enter user name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        UserEntity user = new UserEntity();
        user.setName(name);

        UserEntity createdUser = userService.save(user);

        System.out.println("User created: " + createdUser);
    }

    @Override
    public String getMenuActionName() {
        return "Create user";
    }
}

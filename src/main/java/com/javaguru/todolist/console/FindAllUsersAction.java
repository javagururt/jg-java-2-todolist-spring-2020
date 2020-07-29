package com.javaguru.todolist.console;

import com.javaguru.todolist.service.UserService;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(5)
class FindAllUsersAction implements MenuAction {


    private final UserService userService;

    FindAllUsersAction(UserService userService) {
        this.userService = userService;
    }

    @Override
//    @Transactional
    public void execute() {
        userService.findAllUsers()
                .forEach(System.out::println);
    }

    @Override
    public String getMenuActionName() {
        return "Find all users";
    }
}

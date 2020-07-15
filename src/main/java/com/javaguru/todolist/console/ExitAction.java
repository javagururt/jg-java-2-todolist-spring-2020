package com.javaguru.todolist.console;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
class ExitAction implements MenuAction {

    @Override
    public void execute() {
        System.out.println("Bye-bye!");
        System.exit(0);
    }

    @Override
    public String getMenuActionName() {
        return "Exit";
    }
}

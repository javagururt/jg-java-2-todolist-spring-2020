package com.javaguru.todolist.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

//@Configuration
class ConsoleUIConfiguration {

    private final MenuAction createTaskAction;
    private final MenuAction exitAction;
    private final MenuAction findTaskByIdAction;

    @Autowired
    ConsoleUIConfiguration(MenuAction createTaskAction,
                           MenuAction exitAction,
                           MenuAction findTaskByIdAction) {
        this.createTaskAction = createTaskAction;
        this.exitAction = exitAction;
        this.findTaskByIdAction = findTaskByIdAction;
    }

    @Bean
    public ConsoleUI ui() {
        List<MenuAction> menuActions = new ArrayList<>();
        menuActions.add(createTaskAction);
        menuActions.add(findTaskByIdAction);
        menuActions.add(exitAction);
        return new ConsoleUI(menuActions);
    }
}

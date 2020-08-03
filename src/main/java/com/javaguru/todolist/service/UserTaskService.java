package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.TaskEntity;
import com.javaguru.todolist.domain.UserEntity;

import org.springframework.stereotype.Service;

@Service
public class UserTaskService {

    private final UserService userService;
    private final TaskService taskService;

    UserTaskService(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }


    public void assignTaskToUser(Long taskId, Long userId) {
        TaskEntity task = taskService.findTaskById(taskId);
        UserEntity user = userService.findUserById(userId);
        task.setUser(user);
        taskService.update(task);
    }
}

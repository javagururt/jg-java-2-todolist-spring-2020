package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.Task;
import com.javaguru.todolist.repository.TaskInMemoryRepository;
import com.javaguru.todolist.repository.TaskRepository;
import com.javaguru.todolist.service.validation.TaskNotFoundException;
import com.javaguru.todolist.service.validation.TaskValidationService;

public class TaskService {

    private final TaskRepository taskRepository = new TaskInMemoryRepository();
    private final TaskValidationService validationService = new TaskValidationService();

    public Task save(Task task) {
        validationService.validate(task);
        return taskRepository.save(task);
    }

    public Task findTaskById(Long id) {
        return taskRepository.findTaskById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found, id: " + id));
        /*
        Optional<Task> taskById = taskRepository.findTaskById(id);

        if (taskById.isPresent()) {
            return taskById.get();
        } else {
            throw new TaskNotFoundException("Task not found, id: " + id);
        }
        */
    }
}

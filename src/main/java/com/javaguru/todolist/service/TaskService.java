package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.TaskEntity;
import com.javaguru.todolist.dto.TaskDto;
import com.javaguru.todolist.mappers.BeanMapper;
import com.javaguru.todolist.repository.TaskInMemoryRepository;
import com.javaguru.todolist.service.validation.TaskNotFoundException;
import com.javaguru.todolist.service.validation.TaskValidationService;

public class TaskService {

    private TaskInMemoryRepository taskRepository = new TaskInMemoryRepository();
    private TaskValidationService validationService = new TaskValidationService();
    private BeanMapper beanMapper = new BeanMapper();

    public TaskDto save(TaskDto taskDto) {
        validationService.validate(taskDto);
        TaskEntity entity = beanMapper.toEntity(taskDto);
        TaskEntity savedEntity = taskRepository.save(entity);
        return beanMapper.toDto(savedEntity);
    }

    public TaskEntity findTaskById(Long id) {
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

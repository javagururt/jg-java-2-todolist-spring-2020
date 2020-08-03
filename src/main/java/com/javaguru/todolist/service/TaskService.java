package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.TaskEntity;
import com.javaguru.todolist.dto.TaskDto;
import com.javaguru.todolist.mappers.BeanMapper;
import com.javaguru.todolist.repository.TaskRepository;
import com.javaguru.todolist.service.validation.TaskNotFoundException;
import com.javaguru.todolist.service.validation.TaskValidationService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskValidationService validationService;
    private final BeanMapper beanMapper;

    public TaskService(TaskRepository taskRepository,
                       TaskValidationService validationService,
                       BeanMapper beanMapper) {
        this.taskRepository = taskRepository;
        this.validationService = validationService;
        this.beanMapper = beanMapper;
    }

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

    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }

    public void update(TaskEntity taskEntity) {
        taskRepository.update(taskEntity);
    }
}

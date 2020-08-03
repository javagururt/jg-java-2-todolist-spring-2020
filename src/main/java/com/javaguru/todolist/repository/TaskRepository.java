package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.TaskEntity;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    TaskEntity save(TaskEntity taskEntity);

    Optional<TaskEntity> findTaskById(Long id);

    Optional<TaskEntity> findTaskByName(String name);

    List<TaskEntity> findAll();

    void update(TaskEntity taskEntity);
}

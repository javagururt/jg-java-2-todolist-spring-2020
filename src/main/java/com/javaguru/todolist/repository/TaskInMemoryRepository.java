package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.TaskEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TaskInMemoryRepository implements TaskRepository {

    private final Map<Long, TaskEntity> repository = new HashMap<>();
    private long taskIdSequence = 0L;

    @Override
    public TaskEntity save(TaskEntity taskEntity) {
        TaskEntity taskEntityCopy = new TaskEntity(taskIdSequence++, taskEntity.getName(), taskEntity.getDescription());
        repository.put(taskEntityCopy.getId(), taskEntityCopy);
        return taskEntityCopy;
    }

    @Override
    public Optional<TaskEntity> findTaskById(Long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public Optional<TaskEntity> findTaskByName(String name) {
//        for (TaskEntity entity : repository.values()) {
//            if (entity.getName().equalsIgnoreCase(name)) {
//                return Optional.of(entity);
//            }
//        }
//        return Optional.empty();
        return repository.values().stream()
                .filter(entity -> entity.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}

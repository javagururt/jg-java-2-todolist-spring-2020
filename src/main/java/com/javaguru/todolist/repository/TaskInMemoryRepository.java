package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.TaskEntity;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@Profile("inmemory")
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

    @Override
    public List<TaskEntity> findAll() {
        return null;
    }
}

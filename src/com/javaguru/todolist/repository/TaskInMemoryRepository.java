package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TaskInMemoryRepository implements TaskRepository {

    private final Map<Long, Task> repository = new HashMap<>();
    private long taskIdSequence = 0L;

    @Override
    public Task save(Task task) {
        Task taskCopy = new Task(taskIdSequence++, task.getName(), task.getDescription());
        repository.put(taskCopy.getId(), taskCopy);
        return taskCopy;
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        return Optional.ofNullable(repository.get(id));
    }
}

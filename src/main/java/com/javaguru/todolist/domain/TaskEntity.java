package com.javaguru.todolist.domain;

import java.util.Objects;

public class TaskEntity {

    private final Long id;
    private final String name;
    private final String description;

    public TaskEntity(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity taskEntity = (TaskEntity) o;
        return Objects.equals(id, taskEntity.id) &&
                Objects.equals(name, taskEntity.name) &&
                Objects.equals(description, taskEntity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

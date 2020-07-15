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

    private TaskEntity(Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
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


    public static final class Builder {
        private Long id;
        private String name;
        private String description;

        public Builder() {
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public TaskEntity build() {
            return new TaskEntity(this);
        }
    }
}

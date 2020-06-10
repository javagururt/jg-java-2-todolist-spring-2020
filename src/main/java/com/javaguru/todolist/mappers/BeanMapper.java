package com.javaguru.todolist.mappers;

import com.javaguru.todolist.domain.TaskEntity;
import com.javaguru.todolist.dto.TaskDto;

import org.springframework.stereotype.Component;

@Component
public class BeanMapper {

    public TaskDto toDto(TaskEntity entity) {
        TaskDto dto = new TaskDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public TaskEntity toEntity(TaskDto dto) {
        return new TaskEntity(dto.getId(), dto.getName(), dto.getDescription());
    }
}

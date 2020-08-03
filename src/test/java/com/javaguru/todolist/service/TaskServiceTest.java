package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.TaskEntity;
import com.javaguru.todolist.dto.TaskDto;
import com.javaguru.todolist.mappers.BeanMapper;
import com.javaguru.todolist.repository.TaskRepository;
import com.javaguru.todolist.service.validation.TaskValidationService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository repository;
    @Mock
    private TaskValidationService validationService;
    @Mock
    private BeanMapper beanMapper;

    @InjectMocks
    private TaskService victim;

    @Test
    public void shouldSaveTask() {
        when(repository.save(any())).thenReturn(entity());
        when(beanMapper.toDto(entity())).thenReturn(taskDto(20L));

        TaskDto dto = victim.save(taskDto(null));

        verify(validationService).validate(any());
        assertEquals(taskDto(20L), dto);
    }

    private TaskDto taskDto(Long id) {
        TaskDto dto = new TaskDto();
        dto.setId(id);
        dto.setName("TASK");
        dto.setDescription("TASK_DESCRIPTION");
        return dto;
    }

    private TaskEntity entity() {
        TaskEntity taskEntity = new TaskEntity(20L, "TASK", "DESCRIPTION");
        return taskEntity;
    }
}
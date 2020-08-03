package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.domain.TaskEntity;
import com.javaguru.todolist.dto.TaskDto;
import com.javaguru.todolist.repository.TaskRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskUniqueNameValidationRuleTest {

    public static final String TASK_NAME = "TEST_UNIQUE_NAME";
    public static final String TASK_DESCRIPTION = "TEST_DESCRIPTION";

    @Mock
    private TaskRepository inMemoryRepository;

    @Spy
    @InjectMocks
    private TaskUniqueNameValidationRule victim;

    @Test
    public void shouldThrowExceptionTaskNameMustBeUnique() {
        TaskEntity entity = new TaskEntity(1L, TASK_NAME, TASK_DESCRIPTION);
        when(inMemoryRepository.findTaskByName(TASK_NAME)).thenReturn(Optional.of(entity));
        TaskDto input = new TaskDto();
        input.setName(TASK_NAME);

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidationExceptionMessages.UNIQUE_NAME_VALIDATION_MSG);

        verify(victim).checkNotNull(input);
    }

    @Test
    public void shouldNotThrowException() {
        TaskDto input = new TaskDto();
        input.setName(TASK_NAME);

        victim.validate(input);
        verify(victim).checkNotNull(input);
    }
}
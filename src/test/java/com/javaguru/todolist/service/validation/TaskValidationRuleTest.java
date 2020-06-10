package com.javaguru.todolist.service.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class TaskValidationRuleTest {

    @Spy
    private TaskValidationRule victim;

    @Test
    public void shouldThrowExceptionWhenTaskIsNull() {
        assertThatThrownBy(() -> victim.checkNotNull(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Task must be not null.");
    }
}
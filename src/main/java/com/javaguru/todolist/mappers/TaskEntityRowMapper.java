package com.javaguru.todolist.mappers;

import com.javaguru.todolist.domain.TaskEntity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskEntityRowMapper implements RowMapper<TaskEntity> {

    @Override
    public TaskEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TaskEntity.Builder()
                .withId(rs.getLong("id"))
                .withName(rs.getString("name"))
                .withDescription(rs.getString("description"))
                .build();
    }
}

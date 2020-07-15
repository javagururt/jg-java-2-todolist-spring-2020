package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.TaskEntity;
import com.javaguru.todolist.mappers.TaskEntityRowMapper;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("mysql")
class DatabaseTaskRepository implements TaskRepository {

    private final JdbcTemplate jdbcTemplate;

    DatabaseTaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TaskEntity save(TaskEntity taskEntity) {
        String query = "INSERT INTO task (name, description) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, taskEntity.getName());
            preparedStatement.setString(2, taskEntity.getDescription());
            return preparedStatement;
        }, keyHolder);
        return new TaskEntity(
                keyHolder.getKey().longValue(),
                taskEntity.getName(),
                taskEntity.getDescription()
        );
    }

    @Override
    public Optional<TaskEntity> findTaskById(Long id) {
        //query with a problem (Sql Injection)
        String query = "SELECT * FROM task WHERE id=?";
        TaskEntity taskEntity = jdbcTemplate.queryForObject(query, new Object[]{id}, new TaskEntityRowMapper());
        return Optional.ofNullable(taskEntity);
    }

    @Override
    public Optional<TaskEntity> findTaskByName(String name) {
        //query with a problem (Sql Injection)
        String query = "SELECT * FROM task WHERE name=" + name;
        TaskEntity taskEntity = jdbcTemplate.queryForObject(query, new TaskEntityRowMapper());
        return Optional.ofNullable(taskEntity);
    }

    @Override
    public List<TaskEntity> findAll() {
        String query = "SELECT * FROM task";
        return jdbcTemplate.query(query, new TaskEntityRowMapper());
    }

}

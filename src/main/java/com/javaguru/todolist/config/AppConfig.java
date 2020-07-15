package com.javaguru.todolist.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.javaguru.todolist")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String userPassword;
    @Value("${database.url}")
    private String databaseUrl;
    @Value("${database.driverName}")
    private String databaseDriverName;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(userPassword);
        dataSource.setDriverClassName(databaseDriverName);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}

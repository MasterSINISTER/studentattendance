package com.attendance.studentattendance.run;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RunRepo {
    private static final Logger log = LoggerFactory.getLogger(RunRepo.class);
    private final JdbcClient jdbcClient;

    public RunRepo(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("SELECT * FROM Run")
                .query(Run.class)
                .list();
    }

    public Optional<Run> findById(Integer id) {
        return jdbcClient.sql("SELECT * FROM Run WHERE RollNo = :id") // Use :id for the parameter placeholder
                .param("id", id)
                .query(Run.class)
                .optional();
    }

    public void create(Run run) {
        var updated = jdbcClient.sql("INSERT INTO Run (RollNo, name, status, totalPresent, totalAbsent) VALUES (?, ?, ?, ?, ?)")
                .params(run.RollNo(), run.name(), run.status(), run.totalPresent(), run.totalAbsent()) // Use individual parameters instead of List
                .update();
    }

    public void update(Run run, Integer roll) {
        var updated = jdbcClient.sql("UPDATE Run SET name = ?, status = ?, totalPresent = ?, totalAbsent = ? WHERE RollNo = ?")
                .params(run.name(), run.status(), run.totalPresent(), run.totalAbsent(), roll) // Use individual parameters
                .update();
    }

    public void delete(Integer roll) {
        var updated = jdbcClient.sql("DELETE FROM Run WHERE RollNo = :id")
                .param("id", roll)
                .update();
    }

    public void deleteAll() {
        var updated = jdbcClient.sql("DELETE FROM Run")
                .update();
    }
}

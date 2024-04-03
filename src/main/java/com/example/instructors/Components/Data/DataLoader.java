package com.example.instructors.Components.Data;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@Service
@RequiredArgsConstructor
public class DataLoader {

    private final DataSource dataSource;

    public void executeDataScript() throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(conn, new ClassPathResource("data.sql"));
        }
    }

    public void clearDatabase() throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(conn, new ClassPathResource("clear-data.sql"));
        }
    }
}

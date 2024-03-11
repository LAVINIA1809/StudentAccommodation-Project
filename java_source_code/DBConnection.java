package org.example;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {

    private static HikariDataSource dataSource;

    private DBConnection() {}

    public static Connection getConnection() {
        if (dataSource == null) {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:oracle:thin:@//localhost:1521/XE");
            config.setUsername("STUDENTACCOMMODATION");
            config.setPassword("STUDENT");
            config.setMaximumPoolSize(10);
            dataSource = new HikariDataSource(config);
        }
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Connection failed", e);
        }
    }
}

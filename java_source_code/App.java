package org.example;
import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("Successfully connected to Oracle database STUDENTACCOMMODATION :)");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}

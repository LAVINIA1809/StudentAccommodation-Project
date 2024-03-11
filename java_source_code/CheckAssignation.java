package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckAssignation {
    public static String studentDormAssignation(String studentId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String firstName=null;
        String lastName=null;
        int dormId = 0;
        String query = "SELECT first_name, last_name, dorm_id FROM students WHERE student_id = ?";

        PreparedStatement statement2 = null;
        ResultSet resultSet2 = null;
        String dormName = null;
        String query2 = "SELECT dorm_name FROM dorms WHERE dorm_id = ?";
        String message = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, studentId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                firstName = resultSet.getString("first_name");
                lastName = resultSet.getString("last_name");
                dormId = resultSet.getInt("dorm_id");
            }

            statement2 = connection.prepareStatement(query2);
            statement2.setInt(1, dormId);
            resultSet2 = statement2.executeQuery();
            if(resultSet2.next())
            {
                dormName = resultSet2.getString("dorm_name");
            }

            if(firstName == null)
                message = "Student doesn't exist in the database!";
            else{
                if(dormId != 0)
                    message = "Student " + firstName + " " + lastName + " was assigned to dorm " + dormName + ".";
                else
                    message = "Student " + firstName + " " + lastName + " wasn't assigned to any dorm.";
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet2 != null)
                    resultSet2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement2 != null)
                    statement2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return message;
    }
}

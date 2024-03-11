package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRegistration {

    private static int allStudents = 0;
    public static void registerStudent(String studentID, String faculty, String firstName, String lastName, double averageGrade, String email, String phone, String gender,
                                       String preference1, String preference2, String preference3, String preference4, String preference5, String preference6)
            throws SQLException
    {
        Connection connection = DBConnection.getConnection();
        String query = "SELECT COUNT(*) FROM STUDENTS";
        PreparedStatement selectStatement = connection.prepareStatement(query);
        ResultSet resultSetAllStudents = selectStatement.executeQuery();

        if(resultSetAllStudents.next())
        {
            allStudents = resultSetAllStudents.getInt(1);
        }

        resultSetAllStudents.close();
        selectStatement.close();

        String insertQuery = "INSERT INTO students (id, student_id, faculty_name, first_name, last_name, average_grade, email, phone, gender, preference1, preference2, preference3, preference4, preference5, preference6) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setInt(1, allStudents + 1);
        statement.setString(2, studentID);
        statement.setString(3, faculty);
        statement.setString(4, firstName);
        statement.setString(5, lastName);
        statement.setDouble(6, averageGrade);
        statement.setString(7, email);
        statement.setString(8, phone);
        statement.setString(9, gender);
        statement.setString(10, preference1);
        statement.setString(11, preference2);
        statement.setString(12, preference3);
        statement.setString(13, preference4);
        statement.setString(14, preference5);
        statement.setString(15, preference6);

        int rowsAffected = statement.executeUpdate();
        statement.close();
    }
}

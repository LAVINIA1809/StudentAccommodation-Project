package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepartition {

    private static final Connection connection = DBConnection.getConnection();

    public static boolean studentNotAssigned(String studentId) throws SQLException {
        int dormId = 0;
        String query = "SELECT dorm_id from students where student_id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, studentId);
            resultSet = statement.executeQuery();

            if (resultSet.next())
                dormId = resultSet.getInt("dorm_id");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dormId == 0;
    }

    public static int getGirlsSpotsAvailable(String facultyName, int dormId)
    {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT girls_spots FROM faculties_and_dorms WHERE faculty_name = ? AND dorm_id = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, facultyName);
            statement.setInt(2, dormId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int girlsSpots = resultSet.getInt("girls_spots");
                return girlsSpots;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static void updatedGirlsSpots(String facultyName, int dormId){
        PreparedStatement statement = null;
        String query = "UPDATE faculties_and_dorms SET girls_spots = girls_spots - 1 WHERE faculty_name = ? AND dorm_id = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, facultyName);
            statement.setInt(2, dormId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Spots updated successfully");
            } else {
                System.out.println("Spots were not updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getBoysSpotsAvailable(String facultyName, int dormId)
    {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT boys_spots FROM faculties_and_dorms WHERE faculty_name = ? AND dorm_id = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, facultyName);
            statement.setInt(2, dormId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int boysSpots = resultSet.getInt("boys_spots");
                return boysSpots;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static void updatedBoysSpots(String facultyName, int dormId){
        PreparedStatement statement = null;
        String query = "UPDATE faculties_and_dorms SET boys_spots = boys_spots - 1 WHERE faculty_name = ? AND dorm_id = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, facultyName);
            statement.setInt(2, dormId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Spots updated successfully");
            } else {
                System.out.println("Spots were not updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean checkPreferenceAvailability(String preference, List<Dorm> dorms, Student student) {
        for (Dorm dorm : dorms) {
            if (dorm.getDormName().equals(preference)) {
                if (student.getGender().equals("Female")) {
                    int spots = getGirlsSpotsAvailable(student.getFacultyName(), dorm.getDormId());
                    if (spots > 0) {
                        updatedGirlsSpots(student.getFacultyName(), dorm.getDormId());
                        return true;
                    } else {
                        return false;
                    }
                } else if (student.getGender().equals("Male")) {
                    int spots = getBoysSpotsAvailable(student.getFacultyName(), dorm.getDormId());
                    if (spots > 0) {
                        updatedBoysSpots(student.getFacultyName(), dorm.getDormId());
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }


    public static List<String> getFaculties()
    {
        List<String> faculties = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT DISTINCT faculty_name FROM faculties_and_dorms");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String faculty = resultSet.getString("faculty_name");
                faculties.add(faculty);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faculties;
    }

    public static List<Dorm> getDorms() throws SQLException {
        List<Dorm> dorms = new ArrayList<>();
        String query = "SELECT * FROM dorms";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("dorm_id");
                String dormName = resultSet.getString("dorm_name");
                int price = resultSet.getInt("price");
                Dorm dorm = new Dorm(id, dormName, price);
                dorms.add(dorm);
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dorms;
    }
    public static List<Student> getStudentsByAverageGradePerFaculty(String faculty)
    {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students where faculty_name = ? and dorm_id is NULL ORDER BY average_grade DESC";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try
        {
            statement = connection.prepareStatement(query);
            statement.setString(1, faculty);
            resultSet = statement.executeQuery();
            while(resultSet.next())
            {
                int id = resultSet.getInt("id");
                String studentId = resultSet.getString("student_id");
                String facultyName = resultSet.getString("faculty_name");
                String firstname = resultSet.getString("first_name");
                String lastname = resultSet.getString("last_name");
                double averageGrade = resultSet.getDouble("average_grade");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String gender = resultSet.getString("gender");
                int dormId = resultSet.getInt("dorm_id");
                String preference1 = resultSet.getString("preference1");
                String preference2 = resultSet.getString("preference2");
                String preference3 = resultSet.getString("preference3");
                String preference4 = resultSet.getString("preference4");
                String preference5 = resultSet.getString("preference5");
                String preference6 = resultSet.getString("preference6");

                List<String> preferences = new ArrayList<>();
                preferences.add(preference1);
                preferences.add(preference2);
                preferences.add(preference3);
                preferences.add(preference4);
                preferences.add(preference5);
                preferences.add(preference6);

                Student student = new Student(id, studentId, facultyName, firstname, lastname, averageGrade, email, phone, gender, preferences, dormId);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    public static void updateStudentAssignation(String studentId, String preference) {
        String query1 = "SELECT dorm_id FROM dorms WHERE dorm_name = ?";
        String query2 = "UPDATE students SET dorm_id = ? WHERE student_id = ?";
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        int dormId = 0;

        try {
            statement1 = connection.prepareStatement(query1);
            statement1.setString(1, preference);
            resultSet = statement1.executeQuery();
            if (resultSet.next())
                dormId = resultSet.getInt("dorm_id");

            statement2 = connection.prepareStatement(query2);
            statement2.setInt(1, dormId);
            statement2.setString(2, studentId);
            int rowAffected = statement2.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (statement2 != null)
                    statement2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement1 != null) {
                    statement1.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void studentAssignation() throws SQLException {
        List<String> faculties = getFaculties();
        for (String faculty : faculties) {
            List<Dorm> dorms = getDorms();
            List<Student> students = getStudentsByAverageGradePerFaculty(faculty);
            for (Student student : students) {
                if(studentNotAssigned(student.getStudentId())) {
                    for (String preference : student.getPreferences()) {
                        if (checkPreferenceAvailability(preference, dorms, student)) {
                            updateStudentAssignation(student.getStudentId(), preference);
                            break;
                        }
                    }
                }
            }
        }
    }
}

package org.example;

import java.util.List;

public class Student {
    int id;
    String studentId;
    String facultyName;
    String lastName;
    String firstName;
    double averageGrade;
    String email;
    String phone;
    String gender;

    List preferences;
    int dormId;

    public Student(int id, String studentId, String facultyName, String lastName, String firstName,
                   double averageGrade, String email, String phone, String gender, List preferences, int dormId)
    {
        this.id = id;
        this.studentId = studentId;
        this.facultyName = facultyName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.averageGrade = averageGrade;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.preferences = preferences;
        this.dormId = dormId;
    }

    public int getId()
    {
        return id;
    }
    public String getStudentId()
    {
        return studentId;
    }
    public String getFacultyName()
    {
        return facultyName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public double getAverageGrade()
    {
        return averageGrade;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getGender()
    {
        return gender;
    }

    public List<String> getPreferences() {return preferences;}
}

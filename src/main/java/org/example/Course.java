package org.example;

import java.util.ArrayList;

public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    public Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;

    public static int nextId = 0;
}

package org.example;

import java.util.ArrayList;

public class Student {
    private String studentId;
    private String studentName;
    public Gender gender;
    public Address address;
    public Department department;
    private ArrayList<Course> registeredCourses;

    public static int nextId = 0;

    public enum Gender {
        MALE,
        FEMALE
    }
}

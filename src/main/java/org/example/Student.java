package org.example;

import java.util.ArrayList;

public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;

    public static int nextId = 0;

    public enum Gender {
        MALE,
        FEMALE
    }

    public void addCourse(Course course) {
        registeredCourses.add(course);
        course.getStudent().add(this);
    }

    public String toSimplifiedString() {
        String message : // toString method + only courses

        for (Course course : registeredCourses) {
            message += course.getName() + ",";
        }
    }
}

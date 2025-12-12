package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;

    public static int nextId = 0;
    ..= nextId++;

    public enum Gender {
        MALE,
        FEMALE
    }

    public static boolean registerCourse (Course course) {

    }

    public static boolean dropCourse(Course course) {

    }

    // constructor

    // toSimplified String

    public String toSimplifiedString() {
        String message : // toString method + only courses

        for (Course course : registeredCourses) {
            message += course.getName() + ",";
        }
    }

    // toString



//    public void addCourse(Course course) {
//        registeredCourses.add(course);
//        course.getStudent().add(this);
//    }

}

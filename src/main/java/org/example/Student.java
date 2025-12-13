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
//    public static String generateNewId() {
//        return String.format("%d", nextId++);
//    }

    public enum Gender {
        MALE,
        FEMALE
    }

    public static boolean registerCourse (Course course) {

    }

    public static boolean dropCourse(Course course) {

    }

    // constructor

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("%d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>(0);
    }


    // toSimplified String

    public String toSimplifiedString() {
        String message : // toString method + only courses

        for (Course course : registeredCourses) {
            message += course.getName() + ",";
        }
    }

    // toString

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=" + Course. +
                '}';
    }


//    public void addCourse(Course course) {
//        registeredCourses.add(course);
//        course.getStudent().add(this);
//    }

}

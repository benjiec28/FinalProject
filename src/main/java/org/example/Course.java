package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;

    public static int nextId = 0;
    ..= nextId++;

    public static boolean isAssignmentWeightValid() {

    }

    public static boolean registerStudent(Student student) {

    }

    public static int[] calcStudentsAverage() {

    }

    public static boolean addAssignment(String assignmentName, double weight, int maxScore) {

    }

    public static void generateScores() {

    }

    public static void displayScores() {

    }

    public static String toSimplifiedString() {

    }

    // toString

}

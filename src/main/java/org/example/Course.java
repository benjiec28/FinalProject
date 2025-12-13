package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Array;
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
    public static String generateNewId() {
        return String.format("%d", nextId++);};

    public static boolean isAssignmentWeightValid() {
        int totalSum = 0;
        ArrayList<Assignment> assignments = new ArrayList<>();
        Assignment assignment = new Assignment();

        for (int i = 0; i < assignments.size(); i++) {
            assignments.get(i);
            int weight = Assignment.getWeight;
            int weightPercentage = weight / 100;
            i *= weightPercentage;
            totalSum += i;
        }

        if (totalSum == 100) {
            return true;
        }

        return false;
    }

    public static boolean registerStudent(Student student) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(0, student);

    }

    public static int[] calcStudentsAverage() {
        int[] averages = new int[];
        ArrayList<Assignment> assignments = new ArrayList<>();
        int avg = 0;
        for (int i = 0; i < averages.length; i++) {
            assignments.get(i);
            int weight = Assignment.getWeight;
            int weightPercentage = weight / 100;
            i *= weightPercentage;
            avg += i;
        }
    }

    public static boolean addAssignment(String assignmentName, double weight, int maxScore) {

    }

    public static void generateScores() {
        System.out.printf("Course: %s\n", courseId);
        System.out.print("                        Assignment01   Assignment02   Assignment03         Exam01         Exam02    Final Score\n");
        System.out.printf(" Ethan Collins             %02d           %02d            %02d             %02d           %02d          %02d\n");
    }

    public static void displayScores() {

    }

    public static String toSimplifiedString() {

    }



}

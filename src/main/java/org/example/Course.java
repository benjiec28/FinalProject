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
    public ArrayList<Student> registeredStudents;


    public static int nextId = 0;
    public static String generateNewId() {
        return String.format("C-%d-%d", Department.departmenId, nextId++);};

    public Course(String courseId, String courseName, double credits, Department department) {
        this.courseId = courseId;
        this.courseName =  Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
    }

    public static boolean isAssignmentWeightValid() {
        int totalSum = 0;
        ArrayList<Assignment> assignments = new ArrayList<>();
        Assignment assignment = new Assignment();

        for (int i = 0; i < assignments.size(); i++) {
            assignments.get(i);
            int weight = Assignment.Weight();
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
        ArrayList<Student> registeredStudents = new ArrayList<>();
        int size = registeredStudents.size();
        ArrayList<Assignment> assignments = new ArrayList<>();

        int[] avgArray = new int[size];
        int avg = 0;

        for (int i = 0; i < avgArray.length; i++) {
            assignments.get(i);
            int weight = Assignment.getWeight;
            int weightPercentage = weight / 100;
            i *= weightPercentage;
            avg += i;
        }

        for ()

    }

    public static boolean addAssignment(String assignmentName, double weight, int maxScore) {

    }

    public void generateScores() {

    }

    public void displayScores() {
        System.out.printf("Course: %s\n", courseId);
        System.out.print("                        Assignment01   Assignment02   Assignment03         Exam01         Exam02    Final Score\n");
        System.out.printf(" Ethan Collins             %02d           %02d            %02d             %02d           %02d          %02d\n");
    }

    public static String toSimplifiedString() {

    }



}

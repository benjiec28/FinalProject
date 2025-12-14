package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

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
    private ArrayList<Double> finalScores;

    public static int nextId = 0;

    public Course(String courseId, String courseName, double credits, Department department) {
        this.courseId = String.format("C-%d-%02d", department.getDepartmentId(), nextId++);
        this.courseName =  Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
    }

    /**
     *
     * @return
     */
    public boolean isAssignmentWeightValid() {
        double totalSum = 0;
        double totalWeight = 100;

        for (Assignment assignment : assignments) {
            totalSum += assignment.getWeight();
        }
        return totalSum == totalWeight;

    }

    /**
     *
     * @param student
     * @return
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);

            finalScores.add(null);
        }

        return true;
    }

    /**
     *
     * @return
     */
    public int[] calcStudentsAverage() {
        int totalStudents = registeredStudents.size();
        int[] finalScoresArray = new int[totalStudents];

        finalScores.clear();

        for (int i = 0; i < totalStudents; i++) {
            double totalWeight = 0.0;

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);

                if (score != null) {
                    totalWeight += score * (assignment.getWeight() / 100);
                }

                int roundScore = (int) Math.round(totalWeight);
                finalScores.add((double) roundScore);

                finalScoresArray[i] = roundScore;
            }
        }

        return finalScoresArray;
    }

    /**
     *
     * @param assignmentName
     * @param weight
     * @param maxScore
     * @return
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment assignment = new Assignment(assignmentName, weight, maxScore);

        assignments.add(assignment);

        for (int i = 0; i < registeredStudents.size(); i++) {
            assignment.getScores().add(null);
        }

        return true;

    }

    /**
     *
     */
    public void generateScores() {
        Random random = new Random();
    }

    /**
     *
     */
    public void displayScores() {
        System.out.printf("Course: %s\n", courseId);
        System.out.print("                        Assignment01   Assignment02   Assignment03         Exam01         Exam02    Final Score\n");
        System.out.printf(" Ethan Collins             %02d           %02d            %02d             %02d           %02d          %02d\n");
    }

    /**
     *
     * @return
     */
    public static String toSimplifiedString() {

    }



}

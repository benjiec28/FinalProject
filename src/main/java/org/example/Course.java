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
        int totalStudents = registeredStudents.size();

        for (Assignment assignment : assignments) {

            for (int i = 0; i < totalStudents; i++) {
                int maxScore = 100;
                int randomScore = random.nextInt(maxScore + 1);

                assignment.getScores().set(i, randomScore);
            }
        }

        this.calcStudentsAverage();
    }

    /**
     *
     */
    public void displayScores() {
        // Title
        System.out.printf("Course : " + courseName + "(" + courseId + ")");
        System.out.println();

        // List of Assignments + Final Score
        System.out.printf("%-20", "");
        for (Assignment assignment : assignments) {
            System.out.printf("%-15", assignment.getAssignmentName());
        }

        System.out.printf("%-15%n", "FinalScore");

        // Student Name + Scores
        for (int i = 0; i< registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);

            System.out.printf("%-20s", student.getStudentName());

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                System.out.printf("%-15d%n", score == null ? "-" : score);
            }
            System.out.printf("");
        }

        // Averages
        System.out.printf("%-20s", "Average");
        for (Assignment assignment : assignments) {
            int sum = 0;
            int count = 0;

            for (Integer score : assignment.getScores()) {
                if (score != null) {
                    sum += score;
                    count ++;
                }
            }

            int avg = count == 0 ? 0 : Math.round(sum / count);
            System.out.printf("%-15d", avg);
        }

        System.out.println();

    }

    /**
     *
     * @return
     */
    public static String toSimplifiedString() {

    }



}

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

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%d-%02d", department.getDepartmentId(), nextId++);
        this.courseName =  Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

    /**
     * checks if the sum of all assignments is equal to 100%.
     * @return true if it's equal to 100% ; false if it returns any other value.
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
     * add student to registered students list.
     * makes all new assignments null.
     * makes final score null.
     * @param student the student.
     * @return true if the student was registered to the registered student list ; false if the student is already on the list.
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
     * calculates the weighted average of a student.
     * @return the weighted average of the students.
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
     * adds a new assignment.
     * @param assignmentName the name of the assignment.
     * @param weight the weight of the assignment.
     * @param maxScore the max score of the assignment.
     * @return true if the assignment was added  ; false if the assignment was already present is the assignments list.
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment assignment = new Assignment(assignmentName, weight, maxScore);

        if (assignments.contains(assignment)) {
            return false;
        }

        assignments.add(assignment);

        for (int i = 0; i < registeredStudents.size(); i++) {
            assignment.getScores().add(null);
        }

        return true;

    }

    /**
     * generates random scores.
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
     * displays all student scores.
     */
    public void displayScores() {
        // Title
        System.out.printf("Course : " + courseName + "(" + courseId + ")");
        System.out.println();

        // List of Assignments + Final Score
        System.out.printf("%-20s", "");
        for (Assignment assignment : assignments) {
            System.out.printf("%-15s", assignment.getAssignmentName());
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
            int totalScore = 0;
            int numAssignments = 0;

            for (Integer score : assignment.getScores()) {
                if (score != null) {
                    totalScore += score;
                    numAssignments ++;
                }
            }

            int avg = numAssignments == 0 ? 0 : Math.round(totalScore / numAssignments);
            System.out.printf("%-15d", avg);
        }

        System.out.println();

    }

    public String toSimplifiedString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + department.getDepartmentName() +
                '}';
    }

    @Override
    public String toString() {
        String string = "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", department=" + department.getDepartmentName() + "\n";

        string += "assignments=";
        for (Assignment assignment : assignments) {
            string += assignment.getAssignmentName() + "(" + assignment.getWeight() +"%)";
        }

        string += "\n";

        string += "students=";
        for (Student student : registeredStudents) {
            string += student.getStudentId() + "-" + student.getStudentName() + "(" + student.getDepartment().getDepartmentName();
        }

        string += "\n";

        string += "validity of assignment weight=" + isAssignmentWeightValid();

        return string;

    }
}

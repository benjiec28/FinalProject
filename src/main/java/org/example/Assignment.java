package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private static ArrayList<Integer> scores;

    public static int nextId = 0;
    public static String generateNewId() {
        return String.format("%d", nextId++);
    }

    public static void calcAssignmentAvg() {
        int sum = 0;

        for (int score : scores) {
            sum += score;
        }

        int avg = sum / scores.size();
    }

    public static void generateRandomScore() {
        Random random = new Random();
    }

    @Override
    public String toString() {
        return "Assignment{" +
                String.format("assignmentId= " + nextId++ + '\'' +
                ", assignmentName= " + assignmentName + '\'' +
                ", weight= " + weight +
                '}';
    }
}

package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
@EqualsAndHashCode
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;

    public static int nextId = 0;

    public Assignment(String assignmentName, double weight, int maxScore) {
        this.assignmentId = String.format("%d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

    /**
     * calculates the average score for the assignment.
     */
    public void calcAssignmentAvg() {
        int sum = 0;

        for (int score : scores) {
            sum += score;
        }

        int avg = sum / scores.size();
    }

    /**
     * generates random scores for all students in an assignment.
     */
    public void generateRandomScore() {
        Random random = new Random();
        scores.clear();
        int randomScore = 0;

        for (int i = 0; i < scores.size(); i++) {
            int randomValue = random.nextInt(0, 10);

            if (randomValue == 0) {
                randomScore = random.nextInt(0, 60);

            } else if (randomValue == 1 || randomValue == 2) {
                randomScore = random.nextInt(60, 70);

            } else if (randomValue == 3 || randomValue == 4) {
                randomScore = random.nextInt(70, 80);

            } else if (randomValue == 5 || randomValue == 6 || randomValue == 7 || randomValue == 8) {
                randomScore = random.nextInt(80, 90);

            } else if (randomValue == 9 || randomValue == 10) {
                randomScore = random.nextInt(90, 100 + 1);
            }
        }

        scores.add(randomScore);
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
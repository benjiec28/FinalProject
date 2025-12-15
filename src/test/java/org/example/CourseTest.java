package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    Department department = new Department("Programming");
    Course course = new Course("Intro to Programming", 4.0, department);
    Address address = new Address(41, "Vanier", "Montreal", Address.Province.QC, "A1B 2C3");

    @Test
    @DisplayName("isAssignmentWeightValid() : Assignment weight = 100% -> true")
    void isAssignmentWeightValid1() {
        course.addAssignment("assignment 1", 30, 100);
        course.addAssignment("assignment 2", 15, 100);
        course.addAssignment("assignment 3", 55, 100);

        boolean expected = true;
        boolean actual = course.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isAssignmentWeightValid() : Assignment weight < 100% -> false")
    void isAssignmentWeightValid2() {
        course.addAssignment("assignment 1", 25, 100);
        course.addAssignment("assignment 2", 15, 100);
        course.addAssignment("assignment 3", 55, 100);

        boolean expected = false;
        boolean actual = course.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isAssignmentWeightValid() : Assignment weight > 100% -> false")
    void isAssignmentWeightValid3() {
        course.addAssignment("assignment 1", 40, 100);
        course.addAssignment("assignment 2", 15, 100);
        course.addAssignment("assignment 3", 55, 100);

        boolean expected = false;
        boolean actual = course.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("registerStudent() : Registering student -> true")
    void registerStudent1() {
        Student student = new Student("Benjamin", Student.Gender.MALE, address, department);
        Course newCourse = new Course("Intro to Programming", 4.0, department);

        boolean expected = true;
        boolean actual = newCourse.registerStudent(student);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("registerStudent() : Student is already registered -> false")
    void registerStudent2() {
        Student student = new Student("Benjamin", Student.Gender.MALE, address, department);
        Course newCourse = new Course("Intro to Programming", 4.0, department);

        newCourse.registerStudent(student);

        boolean expected = false;
        boolean actual = newCourse.registerStudent(student);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("registerStudent() : Registering multiple students -> true")
    void registerStudent3() {
        Student student1 = new Student("Benjamin", Student.Gender.MALE, address, department);
        Student student2 = new Student("Carl", Student.Gender.MALE, address, department);
        Course newCourse = new Course("Intro to Programming", 4.0, department);

        boolean expected = true;
        boolean actual = newCourse.registerStudent(student1) && newCourse.registerStudent(student2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("calcStudentAverage() : student avg = 65")
    void calcStudentsAverage1() {
        Course newCourse = new Course("Intro to Programming", 4.0, department);
        Student student = new Student("Carl", Student.Gender.MALE, address, department);

        course.addAssignment("assignment 1", 40, 100);
        course.addAssignment("assignment 2", 60, 100);

        newCourse.getAssignments().get(0).getScores().set(0, 75);
        newCourse.getAssignments().get(1).getScores().set(0, 55);

        int[] actual = newCourse.calcStudentsAverage();
        int[] studentExpected = {63};

        Assertions.assertArrayEquals(studentExpected, actual);
    }

    @Test
    @DisplayName("calcStudentAverage() : student avg = 0")
    void calcStudentsAverage2() {
        Course newCourse = new Course("Intro to Programming", 4.0, department);
        Student student = new Student("Carl", Student.Gender.MALE, address, department);

        course.addAssignment("assignment 1", 40, 100);
        course.addAssignment("assignment 2", 60, 100);

        student.registerCourse(newCourse);

        newCourse.getAssignments().get(0).getScores().set(0, null);
        newCourse.getAssignments().get(1).getScores().set(0, null);

        int[] actual = newCourse.calcStudentsAverage();

        int[] studentExpected = {0};

        Assertions.assertArrayEquals(studentExpected, actual);
    }

    @Test
    @DisplayName("calcStudentAverage() : 2 students avg (65 and 80) -> 65, 80 ")
    void calcStudentsAverage3() {
        Course newCourse = new Course("Intro to Programming", 4.0, department);
        Student student1 = new Student("Benjamin", Student.Gender.MALE, address, department);
        Student student2 = new Student("Carl", Student.Gender.MALE, address, department);

        course.addAssignment("assignment 1", 40, 100);
        course.addAssignment("assignment 2", 60, 100);

        student1.registerCourse(newCourse);
        student2.registerCourse(newCourse);

        newCourse.getAssignments().get(0).getScores().set(0, 75);
        newCourse.getAssignments().get(1).getScores().set(0, 60);
        newCourse.getAssignments().get(0).getScores().set(1, 55);
        newCourse.getAssignments().get(1).getScores().set(1, 100);

        int[] actual = newCourse.calcStudentsAverage();

        int[] student1Expected = {63};
        int[] student2Expected = {82};

        Assertions.assertArrayEquals(student1Expected, new int[]{actual[0]});
        Assertions.assertArrayEquals(student2Expected, new int[]{actual[1]});
    }

    @Test
    @DisplayName("addAssignment() : Adding assignments -> true")
    void addAssignment1() {
        Course newCourse = new Course("Intro to Programming", 4.0, department);
        newCourse.setAssignments(new ArrayList<>());

        boolean expected = true;
        boolean actual = newCourse.addAssignment("assignment 1", 40, 100);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("addAssignment() : Adding an already existing assignment -> false")
    void addAssignment2() {
        Course newCourse = new Course("Intro to Programming", 4.0, department);
        newCourse.setAssignments(new ArrayList<>());
        newCourse.addAssignment("assignment 1", 40, 100);

        boolean expected = true;
        boolean actual = newCourse.addAssignment("assignment 1", 40, 100);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("addAssignment() : Adding multiple assignments -> true")
    void addAssignment3() {
        Course newCourse = new Course("Intro to Programming", 4.0, department);
        newCourse.setAssignments(new ArrayList<>());

        boolean expected = true;
        boolean actual = newCourse.addAssignment("assignment 1", 40, 100) &&  newCourse.addAssignment("assignment 2", 15, 100);

        Assertions.assertEquals(expected, actual);
    }
}
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
    @DisplayName("calcStudentAverage() : all assignments = integer -> integer")
    void calcStudentsAverage1() {


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("calcStudentAverage() : all assignments = null -> 0")
    void calcStudentsAverage2() {

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("calcStudentAverage() : assignments are null and integers -> integer")
    void calcStudentsAverage3() {

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("addAssignment() : Adding assignments -> true")
    void addAssignment1() {

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("addAssignment() : Adding an already existing assignment -> false")
    void addAssignment2() {

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("addAssignment() : Adding multiple assignments -> true")
    void addAssignment3() {

        Assertions.assertEquals(expected, actual);
    }
}
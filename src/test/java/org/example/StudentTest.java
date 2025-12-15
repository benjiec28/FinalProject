package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Department department = new Department("Programming");
    Address address = new Address(41, "Vanier", "Montreal", Address.Province.QC, "A1B 2C3");

    @Test
    @DisplayName("registerCourse() : Registering Course -> true")
    void registerCourse1() {
        Student student = new Student("Benjamin", Student.Gender.MALE, address, department);
        Course newCourse = new Course("Intro to Programming", 4.0, department);

        newCourse.addAssignment("assignment1", 30, 100);
        newCourse.setRegisteredStudents(new ArrayList<>());

        boolean expected = true;
        boolean actual = student.registerCourse(newCourse);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("registerCourse() : Course is already registered -> false")
    void registerCourse2() {
        Student student = new Student("Benjamin", Student.Gender.MALE, address, department);
        Course newCourse = new Course("Intro to Programming", 4.0, department);

        newCourse.addAssignment("assignment1", 30, 100);
        newCourse.setRegisteredStudents(new ArrayList<>());

        student.registerCourse(newCourse);

        boolean expected = false;
        boolean actual = student.registerCourse(newCourse);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("registerCourse() : Registering multiple courses -> true")
    void registerCourse3() {
        Student student = new Student("Benjamin", Student.Gender.MALE, address, department);
        Course newCourse1 = new Course("Intro to Programming", 4.0, department);
        Course newCourse2 = new Course("OOP", 2.0, department);

        newCourse1.addAssignment("assignment1", 30, 100);
        newCourse1.setRegisteredStudents(new ArrayList<>());

        newCourse2.addAssignment("assignment2", 20, 100);
        newCourse2.setRegisteredStudents(new ArrayList<>());

        student.registerCourse(newCourse1);

        boolean expected = true;
        boolean actual = student.registerCourse(newCourse2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("dropCourse() : Dropping Course -> true")
    void dropCourse1() {
        Student student = new Student("Benjamin", Student.Gender.MALE, address, department);
        Course newCourse = new Course("Intro to Programming", 4.0, department);

        student.registerCourse(newCourse);

        boolean expected = true;
        boolean actual = student.dropCourse(newCourse);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("dropCourse() : Course has been already dropped -> false")
    void dropCourse2() {
        Student student = new Student("Benjamin", Student.Gender.MALE, address, department);
        Course newCourse = new Course("Intro to Programming", 4.0, department);

        boolean expected = false;
        boolean actual = student.dropCourse(newCourse);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("dropCourse() : Dropping multiple courses -> true")
    void dropCourse3() {
        Student student = new Student("Benjamin", Student.Gender.MALE, address, department);
        Course newCourse1 = new Course("Intro to Programming", 4.0, department);
        Course newCourse2 = new Course("OOP", 2.0, department);

        student.registerCourse(newCourse1);
        student.registerCourse(newCourse2);

        boolean expected = true;
        boolean actual = student.dropCourse(newCourse1) && student.dropCourse(newCourse2);

        Assertions.assertEquals(expected, actual);
    }
}
package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private Assignment assignment;
    public ArrayList<Student> registeredStudents;

    public static int nextId = 0;

    public enum Gender {
        MALE,
        FEMALE
    }

    public static boolean registerCourse (Course course) {
        ArrayList<Course> registeredCourses = new ArrayList<>();

        if (registeredCourses.contains(course)) {
            return false;
        } else {
            registeredCourses.add(course);
            registeredCourses.
        }

        return true;
    }

    public static boolean dropCourse(Course course) {


//        ArrayList<Course> registeredCourses = new ArrayList<>();
//        registeredCourses.remove(course);
//
//        ArrayList<Student> registeredStudents = new ArrayList<>();
//
//        if (!registeredStudents.contains(Student)) {
//            return registeredStudents;
//        } else {
//            registeredStudents.remove(Student);
//        }
//        return registeredStudents.toString() && registeredCourses.toString();
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("%d", nextId++);
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>(0);
    }

    public String toSimplifiedString() {
        String message : // toString method + only courses

        for (Course course : registeredCourses) {
            message += course.getName() + ",";
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=" + +
                '}';
    }

}

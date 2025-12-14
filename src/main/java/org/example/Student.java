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

    public static int nextId = 0;

    public enum Gender {
        MALE,
        FEMALE
    }

    /**
     * adds a course to the registeredCourses list.
     * adds the student to the registeredStudents list.
     * makes the score of each assignment null.
     * @param course the course the student is registering in.
     * @return true if the student is registering to the course ; false if the student is already registered.
     */
    public boolean registerCourse (Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);

        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
        }

        return true;
    }

    /**
     * removes the course from the registeredCourses list.
     * removes the student from the registeredStudents list.
     * @param course the course the student is dropping.
     * @return true if the student is dropping the course ; false if the student is not on the registered course list to begin with.
     */
    public boolean dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
            registeredCourses.remove(course);
            course.getRegisteredStudents().remove(this);

            return true;
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
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName +'\'' +
                ", departmentName=" + department.getDepartmentName() +
                '}';
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=" + registeredCourses.toString() +
                '}';
    }

}

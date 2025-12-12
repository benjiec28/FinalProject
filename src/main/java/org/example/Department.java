package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Department {
    private String departmentId;
    @Setter private String departmentName;

    public static int nextId = 0;
    ..= nextId++;

    public static boolean isDepartmentNameValid(String departmentName) {
        String idxLetters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWWXYZ";
        String idxSpace = " ";

        if (!departmentName.contains(idxLetters) || !departmentName.contains(idxSpace)) {
            return false;
        }

        return true;
    }

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = departmentName;
        } else {
            this.departmentName = null;
        }
    }
}

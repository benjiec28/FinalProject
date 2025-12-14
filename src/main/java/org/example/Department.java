package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Department {
    private String departmentId;
    private String departmentName;

    public static int nextId = 0;

    /**
     * Checks if the department name is valid.
     * @param departmentName the department name
     * @return true if the department name is valid ; false if it's not.
     */
    private static boolean isDepartmentNameValid(String departmentName) {
        for (int i = 0; i < departmentName.length() ; i++) {
            if (!Character.isLetter(i) || Character.isSpaceChar(i)) {
                return false;
            }
        }

        return true;
    }

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("D%02d", nextId++);
            this.departmentName = Util.toTitleCase(departmentName);
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    public void setDepartmentName(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = Util.toTitleCase(departmentName);
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }
}

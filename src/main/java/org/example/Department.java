package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Department {
    private String department;
    @Setter private String departmentName;

    public static int nextid = 0;
}

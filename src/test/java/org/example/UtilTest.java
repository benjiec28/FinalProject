package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    @DisplayName("toTitleCase() : bENJAMIN Elli CuNaNaN -> Benjamin Elli Cunanan")
    void toTitleCase1() {
        String string = "bENJAMIN Elli CuNaNaN";
        String expected = "Benjamin Elli Cunanan";
        String actual = Util.toTitleCase(string);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toTitleCase() : null -> null")
    void toTitleCase2() {
        String string = null;
        String expected = null;
        String actual = Util.toTitleCase(string);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toTitleCase() : -> ")
    void toTitleCase3() {
        String string = "";
        String expected = "";
        String actual = Util.toTitleCase(string);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("calcAssignmentAvg() : ") {

    }
}

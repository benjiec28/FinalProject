package org.example;

import java.util.Arrays;

public class Util {
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] words = str.split(" ");
        String finalStr = "";

        for (String word : words) {
            String firstLetter = word.substring(0, 1).toUpperCase();
            String restOfName = word.substring(1).toLowerCase();
            finalStr = finalStr + firstLetter + restOfName + " ";
        }

        return finalStr.trim();
    }
}

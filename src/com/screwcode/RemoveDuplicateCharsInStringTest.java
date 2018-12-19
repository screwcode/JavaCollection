package com.screwcode;

import java.util.*;

public class RemoveDuplicateCharsInStringTest {
    public static void main(String[] args) {
        assertEquals("cba", RemoveDuplicateCharsInString.removeDuplicateCharsInString("ccbbaa"));
    }

    private static void assertEquals(String expected, String actual) {
        if (!Objects.equals(expected, actual)) {
            throw new IllegalStateException("Expected: " + expected + " but actually get: " + actual);
        }
    }

}

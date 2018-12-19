package com.screwcode;

import java.util.*;

public class CommonElementsInIntegerListTest {
    public static void main(String[] args) {
        assertEquals(CommonElementsInIntegerList.commonElementsIn(Arrays.asList(1), Arrays.asList(2)));
        assertEquals(CommonElementsInIntegerList.commonElementsIn(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4)), 2, 3);
        assertEquals(CommonElementsInIntegerList.commonElementsIn(Arrays.asList(-1, Integer.MIN_VALUE), Arrays.asList(Integer.MAX_VALUE, -1)), -1);
    }

    public static void assertEquals(Set<Integer> actual, Integer... expected) {
        if (!new HashSet<>(Arrays.asList(expected)).equals(actual)) {
            throw new IllegalStateException();
        }
    }
}

package com.screwcode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PointTest {
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(2, 0), new Point(-1, 1), new Point(1, -1), new Point(2, 1), new Point(2, -1));

        // 先x后y，从大到小
        assertEquals(Arrays.asList(new Point(-1, 1), new Point(1, -1), new Point(2, -1), new Point(2, 0), new Point(2, 1)), Point.sort(points));

        points = Arrays.asList(new Point(1234567890, -1234567890), new Point(-1234567890, 1234567890));

        // WTF?
        assertEquals(Arrays.asList(new Point(-1234567890, 1234567890), new Point(1234567890, -1234567890)), Point.sort(points));
    }

    private static void assertEquals(Object expected, Object actual) {
        if (!Objects.equals(expected, actual)) {
            throw new IllegalStateException("Expected " + expected + " but get " + actual);
        }
    }
}

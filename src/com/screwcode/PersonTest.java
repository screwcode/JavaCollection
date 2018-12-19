package com.screwcode;

import java.util.Objects;

public class PersonTest {
    public static void main(String[] args) {
        assertEquals(new Person(1), new Person(1));
        assertNotEquals(new Person(1), new Person(2));
        assertEquals(new Person(10000), new Person(10000));

        assertNotEquals(new GoodPerson(1), new BadPerson(1));
    }

    private static class GoodPerson extends Person {
        public GoodPerson(Integer id) {
            super(id);
        }
    }

    private static class BadPerson extends Person {
        public BadPerson(Integer id) {
            super(id);
        }
    }

    private static void assertEquals(Object expected, Object actual) {
        if (!Objects.equals(expected, actual)) {
            throw new IllegalStateException("Expected " + expected + " but get " + actual);
        }
    }

    private static void assertNotEquals(Object a, Object b) {
        if (Objects.equals(a, b)) {
            throw new IllegalStateException("Unexpected equal: " + a + "/" + b);
        }
    }
}

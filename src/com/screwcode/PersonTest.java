package com.screwcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PersonTest {
    public static void main(String[] args) {
        assertEquals(new Person("Alice"), new Person("Alice"));
        assertNotEquals(new Person("Alice"), new Person("Bob"));

        assertEquals(true, Arrays.asList(new Person("Alice")).contains(new Person("Alice")));
        assertEquals(false, Arrays.asList(new Person("Alice")).contains(new Person("Bob")));

        Set<Person> persons = new HashSet<>();
        persons.add(new Person("Alice"));

        assertEquals(true, persons.contains(new Person("Alice")));
        assertEquals(false, persons.contains(new Person("Bob")));
        assertEquals(false, persons.contains(null));
        assertEquals(false, persons.contains(new Person(null)));
        assertEquals(false, persons.contains(new Object()));

        assertNotEquals(new GoodPerson("Alice"), new BadPerson("Alice"));
    }

    private static class GoodPerson extends Person {
        public GoodPerson(String name) {
            super(name);
        }
    }

    private static class BadPerson extends Person {
        public BadPerson(String name) {
            super(name);
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

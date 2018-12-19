package com.screwcode;

import java.util.HashSet;
import java.util.Objects;

public class PersonTest {
    public static void main(String[] args) {
        assertEquals(new Person("1"), new Person("1"));
        assertNotEquals(new Person("1"), new Person("2"));

        Person person = new Person("1");
        person.setAge(20);

        assertEquals(person, new Person("1"));

        HashSet<Person> set = new HashSet<>();
        set.add(person);

        assertEquals(true, set.contains(person));

        person.setName("张三");

        assertEquals(true, set.contains(person));

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

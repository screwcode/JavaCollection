package com.screwcode;

import java.util.*;

public class CommonElementsInObjectListTest {
    public static void main(String[] args) {
        Person alice = new Person("Alice");
        Person bob = new Person("Bob");
        Person carol = new Person("Carol");
        Person anotherAlice = new Person("Alice");

        assertEquals(alice, alice);
        assertNotEquals(alice, bob);
        assertEquals(alice, anotherAlice);

        assertEquals(CommonElementsInObjectList.commonElementsIn(Arrays.asList(alice), Arrays.asList(bob)));
        assertEquals(CommonElementsInObjectList.commonElementsIn(Arrays.asList(alice, bob), Arrays.asList(bob, carol)), bob);
        assertEquals(CommonElementsInObjectList.commonElementsIn(Arrays.asList(alice, anotherAlice), Arrays.asList(alice, anotherAlice)), alice);
        assertEquals(CommonElementsInObjectList.commonElementsIn(Arrays.asList(alice, anotherAlice), Arrays.asList(alice, anotherAlice)), anotherAlice);
    }

    private static void assertEquals(Person a, Person b) {
        if (!Objects.equals(a, b)) {
            throw new IllegalStateException();
        }
    }

    private static void assertNotEquals(Person a, Person b) {
        if (Objects.equals(a, b)) {
            throw new IllegalStateException();
        }
    }

    private static void assertEquals(Set<Person> actual, Person... expected) {
        if (!new HashSet<>(Arrays.asList(expected)).equals(actual)) {
            throw new IllegalStateException();
        }
    }
}

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void test() {
        assertEquals(new Person("Alice"), new Person("Alice"));
        assertNotEquals(new Person("Alice"), new Person("Bob"));

        assertTrue(Arrays.asList(new Person("Alice")).contains(new Person("Alice")));
        assertFalse(Arrays.asList(new Person("Alice")).contains(new Person("Bob")));

        Set<Person> persons = new HashSet<>();
        persons.add(new Person("Alice"));

        assertTrue(persons.contains(new Person("Alice")));
        assertFalse(persons.contains(new Person("Bob")));
        assertFalse(persons.contains(null));
        assertFalse(persons.contains(new Person(null)));
        assertFalse(persons.contains(new Object()));

        assertNotEquals(new GoodPerson("Alice"), new BadPerson("Alice"));
    }

    private static class GoodPerson extends Person {
        public GoodPerson(String name) {
            super(name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            return super.equals(o);
        }
    }

    private static class BadPerson extends Person {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            return super.equals(o);
        }

        public BadPerson(String name) {
            super(name);
        }
    }
}

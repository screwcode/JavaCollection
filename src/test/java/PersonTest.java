import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void testEquals() {
        assertEquals(new Person("1"), new Person("1"));
        assertNotEquals(new Person("1"), new Person("2"));

        Person person = new Person("1");
        person.setAge(20);

        assertEquals(person, new Person("1"));
    }

    @Test
    public void testContains() {
        Person person = new Person("1");
        HashSet<Person> set = new HashSet<>();
        set.add(person);

        assertTrue(set.contains(person));
        person.setName("张三");
        assertTrue(set.contains(person));
        person.setAge(99);
        assertTrue(set.contains(person));
    }
}

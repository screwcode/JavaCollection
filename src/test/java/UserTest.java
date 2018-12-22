import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void equalsMethodIsCorrect() {
        assertEquals(new User(1, "a"), new User(1, "b"));
        assertEquals(new User(1, "b"), new User(1, "a"));
        assertNotEquals(new User(1, "a"), null);
        assertNotEquals(new User(1, "a"), "");
        assertNotEquals(new User(1, "a"), new Object());
        assertNotEquals(new User(1, "a"), new User(1, "a") {
        });
    }

    @Test
    public void compareToMethodIsCorrect() {
        List<User> users = Arrays.asList(new User(100, "b"), new User(10, "z"), new User(1, "a"), new User(2000, "a"));
        List<String> expectedSortedNames = Arrays.asList("a", "a", "b", "z");

        assertTrue(new User(1, "a").compareTo(new User(2, "b")) < 0);
        assertTrue(new User(1, "b").compareTo(new User(2, "a")) > 0);
        assertEquals(expectedSortedNames, users.stream().sorted().map(User::getName).collect(Collectors.toList()));

        TreeSet<User> treeSet = new TreeSet<>(users);
        assertEquals(4, treeSet.size());
        assertEquals(expectedSortedNames, treeSet.stream().sorted().map(User::getName).collect(Collectors.toList()));
    }
}

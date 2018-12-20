import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CommonElementsInObjectListTest {
    @Test
    public void test() {
        Person alice = new Person("Alice");
        Person bob = new Person("Bob");
        Person carol = new Person("Carol");
        Person anotherAlice = new Person("Alice");

        assertEquals("Alice is equal to Alice itself", alice, alice);
        assertNotEquals("Alice is not equal to Bob", alice, bob);
        assertEquals("Alice is equal to another Alice", alice, anotherAlice);

        assertEquals("No common elements in set [Alice] and set [Bob]",
                CommonElementsInObjectList.commonElementsIn(Arrays.asList(alice), Arrays.asList(bob)),
                setOf());

        assertEquals("Common elements of set [Alice,Bob] and set [Bob,Carol] are [Bob]",
                CommonElementsInObjectList.commonElementsIn(Arrays.asList(alice, bob), Arrays.asList(bob, carol)),
                setOf(bob));

        assertEquals("Common elements of set [Alice,Alice] and set [Alice,Alice] are [Alice]",
                CommonElementsInObjectList.commonElementsIn(Arrays.asList(alice, anotherAlice), Arrays.asList(alice, anotherAlice)),
                alice);

        assertEquals("Common elements of set [Alice,Alice] and set [Alice,Alice] are [Alice]",
                CommonElementsInObjectList.commonElementsIn(Arrays.asList(alice, anotherAlice), Arrays.asList(alice, anotherAlice)),
                anotherAlice);
    }

    private Set<Person> setOf(Person... persons) {
        return Stream.of(persons).collect(Collectors.toSet());
    }
}

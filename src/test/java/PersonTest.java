import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PersonTest {
    @Test
    public void test() {
        assertEquals(new Person(1), new Person(1));
        assertNotEquals(new Person(1), new Person(2));
        assertNotEquals(new Person(10000), new Person(10000));

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
}

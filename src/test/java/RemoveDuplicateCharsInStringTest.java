import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicateCharsInStringTest {
    @Test
    public void test() {
        assertEquals("Removing 'ccbbaa' duplicate chars we'll get 'cba'", "cba", RemoveDuplicateCharsInString.removeDuplicateCharsInString("ccbbaa"));
    }
}

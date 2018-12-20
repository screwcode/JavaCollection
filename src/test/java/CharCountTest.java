import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharCountTest {
    @Test
    public void test() {
        CharCount charCount1 = new CharCount("aabbcc");
        CharCount charCount2 = new CharCount("bcd");

        assertEquals(2, charCount1.count('a'));
        assertEquals(0, charCount1.count('z'));

        // 有两个公共字符：b和c
        assertEquals(2, charCount1.howManyCharsInCommon(charCount2));

        assertEquals(2, charCount1.count('b'));
        assertEquals(2, charCount1.count('c'));

        assertEquals(1, charCount2.count('b'));
        assertEquals(1, charCount2.count('c'));
        assertEquals(1, charCount2.count('d'));

        assertEquals(3, charCount1.chars().size());
        assertEquals(3, charCount2.chars().size());
    }
}

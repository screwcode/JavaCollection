import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class CommonElementsInIntegerListTest {
    @Test
    public void test() {
        assertEquals("No common elements in set [1] and set [2]",
                CommonElementsInIntegerList.commonElementsIn(Arrays.asList(1), Arrays.asList(2)),
                setOf());
        assertEquals("Common elements of set [1,2,3] and set [2,3,4] are [2,3]",
                CommonElementsInIntegerList.commonElementsIn(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4)),
                setOf(2, 3));
        assertEquals("Common elements of set [-1,-2147483648] and set [2147483647,-1] are [-1]",
                CommonElementsInIntegerList.commonElementsIn(Arrays.asList(-1, Integer.MIN_VALUE), Arrays.asList(Integer.MAX_VALUE, -1)),
                setOf(-1));
    }

    private Set<Integer> setOf(Integer... numbers) {
        return Stream.of(numbers).collect(Collectors.toSet());
    }
}

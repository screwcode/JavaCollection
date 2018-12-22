import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommonElementsInIntegerListTest {
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    @Before
    public void setUp() {
        for (int i = 1; i <= 100000; ++i) {
            list1.add(i);
            list2.add(-i);
        }
    }

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

    @Test(timeout = 1000)
    public void efficient() {
        assertTrue(CommonElementsInIntegerList.commonElementsIn(list1, list2).isEmpty());
    }

    private Set<Integer> setOf(Integer... numbers) {
        return Stream.of(numbers).collect(Collectors.toSet());
    }
}

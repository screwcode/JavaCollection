import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class PointTest {
    @Test
    public void test() {
        List<Point> points = Arrays.asList(new Point(2, 0), new Point(-1, 1), new Point(1, -1), new Point(2, 1), new Point(2, -1));

        // 先x后y，从大到小
        assertEquals("We can sort points\n",
                Arrays.asList(new Point(-1, 1), new Point(1, -1), new Point(2, -1), new Point(2, 0), new Point(2, 1)),
                Point.sort(points));

        points = Arrays.asList(new Point(1234567890, -1234567890), new Point(-1234567890, 1234567890));

        // WTF?
        assertEquals(Arrays.asList("We can sort more points\n",
                new Point(-1234567890, 1234567890), new Point(1234567890, -1234567890)),
                Point.sort(points));
    }
}

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IncrementalListTest {
    private IncrementalList incrementalList = new IncrementalList();

    @Test
    public void isIncrementalWithSingleThread() {
        Arrays.asList(1, 3, 2, 4, 6, 5, 1, 10, 12, 9).forEach(incrementalList::addElementOnlyWhenIncremental);
        assertEquals(
                incrementalList.getList(),
                Arrays.asList(1, 3, 4, 6, 10, 12),
                "只有递增的数字才能被放进来！"
        );
    }

    // 反复重复测试，以最大概率地复现问题
    @RepeatedTest(50)
    public void isIncrementalWithMultiThread() {
        // 10个线程并发
        for (int i = 0; i < 10; i++) {
            new Thread(() ->
                    Arrays.asList(1, 3, 2, 4, 6, 5, 1, 10, 12, 9).forEach(incrementalList::addElementOnlyWhenIncremental)
            ).start();
        }

        List<Integer> list = incrementalList.getList();

        for (int i = 0; i < list.size() - 1; ++i) {
            int currentElement = list.get(i);
            int nextElement = list.get(i + 1);
            assertTrue(
                    currentElement < nextElement,
                    "每个元素都应该比下一个元素小！当前元素：," + currentElement + ",下一个元素：" + nextElement
            );
        }
    }
}
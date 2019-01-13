import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    // 反复重复测试，以保证正确性
    @RepeatedTest(10)
    public void isIncrementalWithMultiThread() throws InterruptedException {
        // 100个线程并发
        runConcurrently(100,
                () -> Arrays.asList(1, 3, 2, 4, 2, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16).forEach(incrementalList::addElementOnlyWhenIncremental));

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

    /**
     * 开启threadNum数量的线程，每个线程独立地完成work指定的工作。该方法会等待所有线程的工作结束。
     *
     * @param threadNum 线程数量
     * @param work 每个线程要执行的工作
     */
    private void runConcurrently(int threadNum, Runnable work) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        // 开启threadNum数量的线程，并发地执行工作
        for (int i = 0; i < threadNum; ++i) {
            Thread thread = new Thread(work);
            threads.add(thread);
            thread.start();
        }

        // 等待所有线程结束
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
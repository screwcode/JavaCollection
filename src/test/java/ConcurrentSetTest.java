import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

public class ConcurrentSetTest {
    private ConcurrentTreeSet concurrentTreeSet = new ConcurrentTreeSet();
    // 计数器，作用是生成不重复的整数
    private AtomicInteger counter = new AtomicInteger(0);

    @Test
    public void canAddWithSingleThread() {
        add100DifferentNumbers();

        assertEquals(100, concurrentTreeSet.size(), "添加100个元素之后，结果集的大小是100");
    }

    @RepeatedTest(10) // 重复10次以保证结果的正确性
    public void canAddWithMultiThreads() throws InterruptedException {
        runConcurrently(10, this::add100DifferentNumbers);
        assertEquals(1000, concurrentTreeSet.size(), "10个线程每个添加100个元素，结果集的大小是1000");

        // 检查集合是否是有序的
        assertSetIsOrdered();
    }

    private void add100DifferentNumbers() {
        for (int i = 0; i < 100; ++i) {
            concurrentTreeSet.add(counter.incrementAndGet());
        }
    }

    /**
     * 开启threadNum数量的线程，每个线程独立地完成work指定的工作。该方法会等待所有线程的工作结束。
     *
     * @param threadNum 线程数量
     * @param work 每个线程要执行的工作
     */
    private void runConcurrently(int threadNum, Runnable work) throws InterruptedException {
        // 开启threadNum数量的线程，并发地执行工作
        for (int i = 0; i < threadNum; ++i) {
            new Thread(work).start();
        }

        // 等待1s，等所有线程结束，如果时间太长，可能发生死循环
        Thread.sleep(1000);
    }

    private void assertSetIsOrdered() {
        List<Integer> list = concurrentTreeSet.asList();

        for (int i = 0; i < list.size() - 1; i++) {
            int currentElement = list.get(i);
            int nextElement = list.get(i + 1);
            assertTrue(currentElement < nextElement, "集合是从小到大排列的！当前元素：" + currentElement + "下一个元素：" + nextElement);
        }
    }
}
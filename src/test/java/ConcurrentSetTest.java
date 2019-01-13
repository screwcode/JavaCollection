import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcurrentSetTest {
    private ConcurrentHashSet concurrentHashSet = new ConcurrentHashSet();

    @Test
    public void canAddWithSingleThread() {
        add100DifferentObjects();
        assertEquals(100, concurrentHashSet.size(), "添加100个元素之后，结果集的大小是100");
    }

    @RepeatedTest(10) // 重复10次以保证结果的正确性
    public void canAddWithMultiThreads() throws InterruptedException {
        // 10个线程并发
        runConcurrently(100, this::add100DifferentObjects);
        assertEquals(10000, concurrentHashSet.size(), "100个线程每个添加100个元素，结果集的大小是10000");
    }

    /**
     * 添加100个新建的对象
     */
    private void add100DifferentObjects() {
        for (int i = 0; i < 100; ++i) {
            concurrentHashSet.add(new Object());
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
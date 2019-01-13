import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcurrentListTest {
    private ConcurrentList concurrentList = new ConcurrentList();

    // 0,1,2,3,...,99
    private List<Integer> manyIntegers = IntStream.range(0, 100).boxed().collect(Collectors.toList());

    @Test
    public void canAddWithSingleThread() {
        manyIntegers.forEach(concurrentList::add);
        assertEquals(100, concurrentList.size(), "添加100个元素之后，结果集的大小是100");
    }

    @Test
    public void canAddWithMultiThreads() throws InterruptedException {
        // 10个线程并发
        runConcurrently(10, () -> manyIntegers.forEach(concurrentList::add));
        assertEquals(1000, concurrentList.size(), "10个线程每个添加100个元素，结果集的大小是1000");
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
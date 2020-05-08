import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 一个在多线程环境下也能安全的添加元素的List
 */
public class ConcurrentList {
    private List<Integer> elements = new ArrayList<>();

    public synchronized void add(Integer i) {
        elements.add(i);
    }

    public int size() {
        return elements.size();
    }
}

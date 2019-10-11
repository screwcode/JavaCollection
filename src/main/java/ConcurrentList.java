import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 一个在多线程环境下也能安全的添加元素的List
 */
public class ConcurrentList {
    private  List<Integer> elements = Collections.synchronizedList(new ArrayList<>());

//    public synchronized void add(Integer i) {
//        elements.add(i);
//    }

    public void add(Integer i) {
        elements.add(i);
    }

    public int size() {
        return elements.size();
    }
}

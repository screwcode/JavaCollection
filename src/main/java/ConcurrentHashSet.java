import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 一个在多线程环境下也能安全的添加元素的HashSet
 */
public class ConcurrentHashSet {
    private Set<Object> elements = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public void add(Object i) {
        elements.add(i);
    }

    public int size() {
        return elements.size();
    }
}

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 一个在多线程环境下也能安全的添加元素的HashSet
 */
public class ConcurrentHashSet {
    private Set<Object> safeElements = Collections.synchronizedSet(new HashSet<>());

    public void add(Object i) {
        safeElements.add(i);
    }

    public int size() {
        return safeElements.size();
    }
}
